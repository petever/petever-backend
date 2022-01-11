package com.example.petever.account.service;

import com.example.petever.account.dto.MailAuthDto;
import com.example.petever.account.entity.EmailAuthEntity;
import com.example.petever.account.entity.UserEntity;
import com.example.petever.account.repository.EmailAuthRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;
    private final EmailAuthRepository emailAuthRepository;
    private final ModelMapper modelMapper;

    public void sendMail(String email) {
        List<String> toUserList = new ArrayList<>();
        toUserList.add(email);

        int toUserSize = toUserList.size();
        int authNo = (int)(Math.random() * (99999 - 10000 + 1)) + 10000;

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toUserList.toArray(new String[toUserSize]));
        simpleMailMessage.setSubject("Petever 회원가입 인증 메일입니다");
        simpleMailMessage.setText("Verification code: " + authNo);
        javaMailSender.send(simpleMailMessage);

        MailAuthDto mailAuthDto = new MailAuthDto(email, String.valueOf(authNo), true);

        System.out.println("modelMapper = " + mailAuthDto.getEmail());
        System.out.println("modelMapper = " + mailAuthDto.getCode());
        System.out.println("modelMapper = " + mailAuthDto.isUse());

        EmailAuthEntity emailAuthEntity = modelMapper.map(mailAuthDto, EmailAuthEntity.class);

        System.out.println("emailAuthEntity.getEmail() = " + emailAuthEntity.getEmail());
        System.out.println("emailAuthEntity.getEmail() = " + emailAuthEntity.getCode());
        System.out.println("emailAuthEntity.getEmail() = " + emailAuthEntity.isUse());

        emailAuthRepository.save(emailAuthEntity);
    }
}
