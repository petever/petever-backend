package com.example.petever.domain.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    private final MailService mailService;

    public TestController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/")
    public void home() {
        mailService.sendMail();
    }
}
