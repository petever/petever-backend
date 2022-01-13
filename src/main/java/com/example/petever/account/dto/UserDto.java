package com.example.petever.account.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserDto {
    private String email;
    private String password;
    private String name;
    private String code;

    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
