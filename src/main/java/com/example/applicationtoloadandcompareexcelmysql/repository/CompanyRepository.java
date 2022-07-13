package com.example.applicationtoloadandcompareexcelmysql.repository;

import com.example.applicationtoloadandcompareexcelmysql.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,String> {
}
