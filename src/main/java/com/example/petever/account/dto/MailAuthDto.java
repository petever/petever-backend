package com.example.petever.account.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MailAuthDto {
    private String email;
    private String code;
    private boolean isUse;

    public MailAuthDto(String email, String code, boolean isUse) {
        this.email = email;
        this.code = code;
        this.isUse = isUse;
    }
}
