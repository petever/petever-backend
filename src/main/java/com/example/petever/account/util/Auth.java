package com.example.petever.account.util;

public class Auth {

    public static boolean isValid(String code, String verificationCode) {
        if (isEmpty(code)) return false;
        if (code.equals(verificationCode)) return true;
        return false;
    }

    private static boolean isEmpty(String code) {
        return code == null || code.length() <= 0;
    }
}
