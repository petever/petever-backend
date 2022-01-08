package com.example.petever.domain.account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nickname {
    private static final String REGEX = "^[가-힣ㄱ-ㅎa-zA-Z0-9._-]{2,}$";

    public boolean isEmpty(String nickname) {
        if (nickname == null || nickname.length() <= 0) return true;
        return false;
    }

    public boolean isValid(String nickname) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(nickname);
        if (matcher.matches()) return true;
        return false;
    }

}
