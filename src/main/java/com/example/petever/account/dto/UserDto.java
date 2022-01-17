package com.example.petever.account.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserDto {

    private final String email;
    private final String password;
    private final String name;
}
