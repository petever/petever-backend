package com.example.petever.account.controller;

import com.example.petever.account.dto.MailAuthDto;
import com.example.petever.account.entity.EmailAuthEntity;
import com.example.petever.account.repository.EmailAuthRepository;
import com.example.petever.account.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mail")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MailController {

    private final MailService mailService;

    @GetMapping("/auth")
    public String checkMailCode(@RequestParam("email") String email, @RequestParam String code, Model model) {
        model.addAttribute("authMessage", mailService.authenticationMailCode(email, code));
        return "mailAuth";
    }

    @ResponseBody
    @PostMapping("/auth")
    public String authenticationMailCode(@RequestParam("email") String email, @RequestParam String code) {
        return mailService.authenticationMailCode(email, code);
    }

    @GetMapping("/auth/check")
    @ResponseBody
    public ResponseEntity<Boolean> checkAuthMail(@RequestParam("email") String email) {
        return ResponseEntity.ok().body(mailService.checkAuthMail(email));
    }

    @ResponseBody
    @PostMapping
    public ResponseEntity<MailAuthDto> sendMailCode(@RequestParam String email) throws MessagingException {
        MailAuthDto emailAuthEntity = mailService.sendMailCode(email);
        return ResponseEntity.ok().body(emailAuthEntity);
    }
}
