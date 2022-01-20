package com.example.petever.account.controller;

import com.example.petever.account.entity.EmailAuthEntity;
import com.example.petever.account.repository.EmailAuthRepository;
import com.example.petever.account.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mail")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MailController {

    private final MailService mailService;

    @GetMapping("/auth")
    public String checkMailCode(@RequestParam("email") String email, @RequestParam String code) {
        EmailAuthEntity emailAuthEntity = mailService.authenticationMailCode(email, code);
        return "mailAuth";
    }

    @ResponseBody
    @PostMapping("/auth")
    public EmailAuthEntity authenticationMailCode(@RequestParam("email") String email, @RequestParam String code) {
        return mailService.authenticationMailCode(email, code);
    }

    @GetMapping("/auth/check")
    @ResponseBody
    public ResponseEntity<Boolean> checkAuthMail(@RequestParam("email") String email) {
        mailService.checkAuthMail(email);
        return ResponseEntity.ok().body(true);
    }

    @ResponseBody
    @PostMapping
    public ResponseEntity<EmailAuthEntity> sendMailCode(@RequestParam String email) throws MessagingException {
        EmailAuthEntity emailAuthEntity = mailService.sendMailCode(email);
        return ResponseEntity.ok().body(emailAuthEntity);
    }
}
