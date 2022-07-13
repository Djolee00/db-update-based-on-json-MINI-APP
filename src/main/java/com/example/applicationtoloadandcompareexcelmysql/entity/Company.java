package com.example.applicationtoloadandcompareexcelmysql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="public_founds_customer")
public class Company {

    @Id
    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

    @Column(name="tax_id")
    private String taxId;

    @Column(name="registration_number")
    private String registrationNumber;

    @Column(name="public_founds_customer_type_code")
    private Integer typeCode;

    @Column(name="deleted")
    private Boolean deleted;

    public Company() {
    }

    public Company(String code, String name, String taxId, String registrationNumber, Integer typeCode, Boolean deleted) {
        this.code = code;
        this.name = name;
        this.taxId = taxId;
        this.registrationNumber = registrationNumber;
        this.typeCode = typeCode;
        this.deleted = deleted;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Company{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", taxId='" + taxId + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", typeCode=" + typeCode +
                ", deleted=" + deleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(code, company.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
