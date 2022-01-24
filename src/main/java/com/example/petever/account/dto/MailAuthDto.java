package com.example.petever.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MailAuthDto {

    private  String email;
    private  String code;
    private  boolean isUse;
}
