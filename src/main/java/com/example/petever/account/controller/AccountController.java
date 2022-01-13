package com.example.petever.account.controller;

import com.example.petever.account.dto.MailAuthDto;
import com.example.petever.account.dto.UserDto;
import com.example.petever.account.entity.EmailAuthEntity;
import com.example.petever.account.repository.EmailAuthRepository;
import com.example.petever.account.service.AccountService;
import com.example.petever.account.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/signup")
public class AccountController {

    private final AccountService accountService;
    private final MailService mailService;
    private final EmailAuthRepository emailAuthRepository;

    @PostMapping("/")
    public String signIn(@RequestBody UserDto userDto) {
        return accountService.signIn(userDto);
    }

    // TODO: 엔티티를 그대로 사용하지말고 DTO로 변환하도록 변경
    // TODO: 어레처리 필요
    @GetMapping("/{email}/mail")
    public String getMailCode(@PathVariable String email) {
        EmailAuthEntity emailAuthEntity = emailAuthRepository.findById(email).orElse(null);
        if (emailAuthEntity == null) return "이메일이 없습니다";       //throw new IllegalArgumentException();
        return emailAuthEntity.getCode();
    }

    @PostMapping("/{email}/mail")
    public String sendMailCode(@PathVariable String email) {
        mailService.sendMail(email);
        return "이메일 발송";
    }

    @PostMapping("/login")
    public void logIn(@RequestBody UserDto userDto){
        String result = accountService.logIn(userDto);
        if(result.equals("OK")){
            System.out.println("로그인 성공");
        }else{
            System.out.println("아이디와 비밀번호를 확인해주세요.");
        }
    }






}
