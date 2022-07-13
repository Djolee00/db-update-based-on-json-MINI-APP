package com.example.applicationtoloadandcompareexcelmysql.controller;

import com.example.applicationtoloadandcompareexcelmysql.entity.Company;
import com.example.applicationtoloadandcompareexcelmysql.service.CompanyService;
import com.example.applicationtoloadandcompareexcelmysql.util.CompanyDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyRestController {

    private final CompanyService companyService;

    public CompanyRestController(CompanyService companyService) {
        this.companyService = companyService;
    }

    //only for testing
    @GetMapping("/companies")
    public List<Company> getCompanies(){
        return companyService.getAllCompaniesFromDatabase();
    }

    //only for testing
    @GetMapping("/json_companies")
    public List<CompanyDTO> getCompaniesFromJSON(@RequestParam String url){
        return companyService.getAllCompaniesFromJSON(url);
    }


    //main endpoint
    @GetMapping("/companies/update")
    public void updateCompanies(@RequestParam String url){
        try {
            companyService.updateDatabaseOfCompanies(url);
        } catch (IOException e) {
            throw new RuntimeException("Exception while writing SQL script");
        }
    }
}
