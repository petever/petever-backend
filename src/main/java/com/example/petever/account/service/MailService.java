package com.example.petever.account.service;

import com.example.petever.account.dto.MailAuthDto;
import com.example.petever.account.entity.EmailAuthEntity;
import com.example.petever.account.entity.UserEntity;
import com.example.petever.account.repository.EmailAuthRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;
    private final EmailAuthRepository emailAuthRepository;
    private final ModelMapper modelMapper;

    public void sendMailCode(String email) {
        List<String> toUserList = new ArrayList<>();
        toUserList.add(email);

        int toUserSize = toUserList.size();
        int authNo = (int)(Math.random() * (99999 - 10000 + 1)) + 10000;

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toUserList.toArray(new String[toUserSize]));
        simpleMailMessage.setSubject("Petever 회원가입 인증 메일입니다");
        simpleMailMessage.setText("Verification code: " + authNo);
        System.out.println("authNo = " + authNo);
        javaMailSender.send(simpleMailMessage);

        MailAuthDto mailAuthDto = new MailAuthDto(email, String.valueOf(authNo), false);
        EmailAuthEntity emailAuthEntity = modelMapper.map(mailAuthDto, EmailAuthEntity.class);
        emailAuthRepository.save(emailAuthEntity);
    }

    public Boolean checkMailCode(String email, String code) {
        EmailAuthEntity emailAuth = emailAuthRepository.findByEmailAndCode(email, code);
        if (LocalDateTime.now().isBefore(emailAuth.getCreatedDate().plusMinutes(10))) emailAuth.changeMailUse(false);
        return emailAuth.isUse();
    }

    public void authenticationMailCode(String email, String code) {
        EmailAuthEntity emailAuth = emailAuthRepository.findByEmailAndCode(email, code);
        System.out.println("emailAuth = " + emailAuth);
        if (emailAuth != null) emailAuth.changeMailUse(true);
    }
}
