package com.example.petever.account.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private static final String REGEX = "^^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";

    public static boolean isValid(String email) {
        if (isEmpty(email)) return false;
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) return true;
        return false;
    }

    public static boolean isEmpty(String email) {
        return email == null || email.length() <= 0;
    }
}
