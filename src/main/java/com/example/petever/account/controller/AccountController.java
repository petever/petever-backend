package com.example.petever.account.controller;

import com.example.petever.account.dto.UserDto;
import com.example.petever.account.entity.EmailAuthEntity;
import com.example.petever.account.exception.ErrorResponse;
import com.example.petever.account.repository.EmailAuthRepository;
import com.example.petever.account.service.AccountService;
import com.example.petever.account.service.MailService;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/signup")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {

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
