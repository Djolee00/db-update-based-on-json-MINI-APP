package com.example.applicationtoloadandcompareexcelmysql.service;

import com.example.applicationtoloadandcompareexcelmysql.entity.Company;
import com.example.applicationtoloadandcompareexcelmysql.util.CompanyDTO;

import java.io.IOException;
import java.util.List;

public interface CompanyService {
    List<Company> getAllCompaniesFromDatabase();

    List<CompanyDTO> getAllCompaniesFromJSON(String url);

    void updateDatabaseOfCompanies(String url) throws IOException;
}
