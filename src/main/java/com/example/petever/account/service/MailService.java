package com.example.petever.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail() {
        List<String> toUserList = new ArrayList<>();
        toUserList.add("rumor1993@naver.com");

        int toUserSize = toUserList.size();
        int authNo = (int)(Math.random() * (99999 - 10000 + 1)) + 10000;

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toUserList.toArray(new String[toUserSize]));
        simpleMailMessage.setSubject("Petever 회원가입 인증 메일입니다");
        simpleMailMessage.setText("Verification code: " + authNo);
        javaMailSender.send(simpleMailMessage);
    }
}
