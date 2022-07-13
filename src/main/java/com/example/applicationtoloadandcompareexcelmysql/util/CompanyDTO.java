package com.example.applicationtoloadandcompareexcelmysql.util;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CompanyDTO {

    @JsonProperty("Jbbk")
    private String code;

    @JsonProperty("Naziv")
    private String name;
    @JsonProperty("Mb")
    private String registrationNumber;
    @JsonProperty("Pib")
    private String taxId;

    @JsonProperty("Tip")
    private String type;

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

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", taxId='" + taxId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyDTO that = (CompanyDTO) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
