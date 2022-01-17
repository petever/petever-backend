package com.example.petever.account.controller;

import com.example.petever.account.dto.UserDto;
import com.example.petever.account.entity.EmailAuthEntity;
import com.example.petever.account.repository.EmailAuthRepository;
import com.example.petever.account.service.AccountService;
import com.example.petever.account.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/signup")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {

    private final AccountService accountService;
    private final MailService mailService;
    private final EmailAuthRepository emailAuthRepository;

    @PostMapping
    public String signUp(@RequestBody UserDto userDto) {
        return accountService.signIn(userDto);
    }

    @GetMapping("/mail/check")
    public Boolean checkMail(@RequestParam String email) {
        return accountService.checkMail(email);
    }

    @PostMapping("/mail")
    public ResponseEntity<EmailAuthEntity> sendMailCode(@RequestParam String email) {
        EmailAuthEntity emailAuthEntity = mailService.sendMailCode(email);
        return ResponseEntity.ok().body(emailAuthEntity);
    }

    @GetMapping("/mail/auth")
    public Boolean checkMailCode(@RequestParam("email") String email, @RequestParam String code) {
        return mailService.checkMailCode(email, code);
    }

    @PostMapping("/mail/auth")
    public void authenticationMailCode(@RequestParam("email") String email, @RequestParam String code) {
        mailService.authenticationMailCode(email, code);
    }
}
