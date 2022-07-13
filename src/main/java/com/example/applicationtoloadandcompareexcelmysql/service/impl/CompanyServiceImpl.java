package com.example.applicationtoloadandcompareexcelmysql.service.impl;


import com.example.applicationtoloadandcompareexcelmysql.entity.Company;
import com.example.applicationtoloadandcompareexcelmysql.repository.CompanyRepository;
import com.example.applicationtoloadandcompareexcelmysql.service.CompanyService;
import com.example.applicationtoloadandcompareexcelmysql.util.CompanyDTO;
import com.example.applicationtoloadandcompareexcelmysql.util.ValidationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final RestTemplate restTemplate;




    public CompanyServiceImpl(CompanyRepository companyRepository, RestTemplate restTemplate) {
        this.companyRepository = companyRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Company> getAllCompaniesFromDatabase() {
        return companyRepository.findAll();
    }

    @Override
    public List<CompanyDTO> getAllCompaniesFromJSON(String url) {
        ResponseEntity<CompanyDTO[]> responseEntity = restTemplate.getForEntity(url,CompanyDTO[].class);
        CompanyDTO[] objects = responseEntity.getBody();

        return Arrays.stream(objects).toList();
    }

    @Override
    public void updateDatabaseOfCompanies(String url) throws IOException {
        List<Company> companiesDB = getAllCompaniesFromDatabase();
        List<CompanyDTO> companiesJSON = getAllCompaniesFromJSON(url);


        //List<Company> newCompanies = new ArrayList<>();
        //List<Company> oldCompanies = new ArrayList<>();

        FileWriter output = new FileWriter("script.sql");
        output.write("");

        for(CompanyDTO c : companiesJSON){
            c.setCode(StringUtils.leftPad(c.getCode(),5,"0"));
            if(!ValidationUtils.isTaxIdValid(c.getTaxId())) {
                c.setTaxId(StringUtils.leftPad(c.getTaxId(), 9, "0"));
            }
            if(!ValidationUtils.isRegNumberValid(c.getRegistrationNumber())) {
                c.setRegistrationNumber(StringUtils.leftPad(c.getRegistrationNumber(), 8, "0"));
            }
            Company company = new Company(c.getCode(),c.getName(),c.getTaxId(),c.getRegistrationNumber(),getTypeCode(c.getType()),false);
            if(!companiesDB.contains(company)){
                //newCompanies.add(company);
                output.append("INSERT INTO public_founds_customer(code,name,tax_id,registration_number,public_founds_customer_type_code,deleted) VALUES('"+
                        company.getCode()+"','"+company.getName()+"','"+company.getTaxId()+"','"+company.getRegistrationNumber()+"',"+company.getTypeCode()+",0);\n");
            }
        }

        output.append("\n\n");
        for (Company c:companiesDB) {
            CompanyDTO temp = new CompanyDTO();
            temp.setCode(c.getCode());
            if(!companiesJSON.contains(temp)){
                //oldCompanies.add(c);
                output.append("UPDATE public_founds_customer SET deleted=1 WHERE code='"+temp.getCode()+"';\n");
            }
        }
        output.flush();
        output.close();

        //Check if sum of number of JSON elements are same as number of DB elements after insert and delete
         /*System.out.println(companiesDB.size());
          System.out.println(companiesJSON.size());
          System.out.println(newCompanies.size());
          System.out.println(oldCompanies.size());*/

    }

    private Integer getTypeCode(String typeCode){
        return Integer.valueOf(typeCode.substring(0,2).trim());
    }
}
