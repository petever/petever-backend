package com.example.petever.account.controller;

import com.example.petever.account.dto.UserDto;
import com.example.petever.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignUpController {

    private final AccountService accountService;

    @PostMapping
    public String signUp(@RequestBody UserDto userDto) {
        return accountService.signIn(userDto);
    }

    @ResponseBody
    @GetMapping("/mail/check")
    public Boolean checkMail(@RequestParam String email) {
        return accountService.checkMail(email);
    }
}
