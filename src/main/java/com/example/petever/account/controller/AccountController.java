package com.example.petever.account.controller;

import com.example.petever.account.dto.UserDto;
import com.example.petever.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/signup")
    public String signIn(@RequestBody UserDto userDto) {
        System.out.println("userDto.getEmail() = " + userDto.getEmail());
        System.out.println("userDto.getPassword() = " + userDto.getPassword());
        System.out.println("userDto.getName() = " + userDto.getName());
        return accountService.signIn(userDto);
    }
}
