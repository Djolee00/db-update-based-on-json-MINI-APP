package com.example.applicationtoloadandcompareexcelmysql.util;

public class ValidationUtils {

    public static boolean isTaxIdValid(String taxValid){
        String regex = "[1-9]\\d{8}";
        return taxValid.matches(regex);
    }

    public static boolean isRegNumberValid(String regNumber){
        String regex = "\\d{8}";
        return regNumber.matches(regex);
    }

}
