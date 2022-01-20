package com.example.petever.account.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private static final String REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d~!@#$%^&*()+|=]{8,20}$";

    public static boolean isEmpty(String password) {
        if (password == null || password.length() <= 0) return true;
        return false;
    }

    public static boolean isValid(String password) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) return true;
        return false;
    }
}
