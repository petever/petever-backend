package com.example.petever.account.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MailAuthDto {

    private final String email;
    private final String code;
    private final boolean isUse;
}
