package com.example.petever.domain.account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    public static final String REGEX = "^^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";

    // TODO: 에러코드로 변경해야함
    public String email(String email) {
        if (isValid(email)) return "이메일 형식을 입력해주세요.";
        return "200";
    }

    public boolean isValid(String email) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) return true;
        return false;
    }

    public boolean isEmpty(String email) {
        return email == null || email.length() <= 0;
    }
}
