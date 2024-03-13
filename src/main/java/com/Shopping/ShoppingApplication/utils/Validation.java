package com.Shopping.ShoppingApplication.utils;

import com.Shopping.ShoppingApplication.Service.UserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean isValidPhoneNumber(String str)
    {
        int n = str.length();
        for(int i=0;i<n;++i) if(str.charAt(i) < '0' || str.charAt(i) > '9') return false;
        return true;
    }
}
