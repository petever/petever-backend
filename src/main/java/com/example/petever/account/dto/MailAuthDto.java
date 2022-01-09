package com.example.petever.account.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MailAuthDto {
    private String email;
    private String code;
}
