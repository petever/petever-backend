package com.example.petever.account.controller;

import com.example.petever.account.dto.MailAuthDto;
import com.example.petever.account.dto.UserDto;
import com.example.petever.account.entity.EmailAuthEntity;
import com.example.petever.account.repository.EmailAuthRepository;
import com.example.petever.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/signup")
public class AccountController {

    private final AccountService accountService;
    private final EmailAuthRepository emailAuthRepository;

    @PostMapping("/")
    public String signIn(@RequestBody UserDto userDto) {
        return accountService.signIn(userDto);
    }

    // TODO: 엔티티를 그대로 사용하지말고 DTO로 변환하도록 변경
    // TODO: 어레처리 필요
    @GetMapping("/{email}/mail")
    public String getMailCode(@PathVariable String email) {
        EmailAuthEntity emailAuthEntity = emailAuthRepository.findById(email).get();
        return emailAuthEntity.getCode();
    }
}
