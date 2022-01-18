package com.example.petever.account.service;

import com.example.petever.account.dto.MailAuthDto;
import com.example.petever.account.entity.EmailAuthEntity;
import com.example.petever.account.repository.EmailAuthRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;
    private final EmailAuthRepository emailAuthRepository;
    private final ModelMapper modelMapper;

    public EmailAuthEntity sendMailCode(String email) throws MessagingException {
        List<String> toUserList = new ArrayList<>();
        toUserList.add(email);

        int toUserSize = toUserList.size();
        int authNo = (int)(Math.random() * (99999 - 10000 + 1)) + 10000;

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper simpleMailMessage = new MimeMessageHelper(mimeMessage, "utf-8");

        // SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(toUserList.toArray(new String[toUserSize]));
        simpleMailMessage.setSubject("Petever 회원가입 인증 메일입니다");
        simpleMailMessage.setText(
                "<form action='http://15.164.222.232:8080/signup/mail/auth' method='POST'>" +
                        "<input hidden type='email' name='email' value="+ email + ">" +
                        "<input hidden type='text' name='code' value="+ authNo + ">" +
                        "<button type='submit'>Send</button>" +
                        "<javascript> </javascript>" +
                        "<button type='submit'>Send</button>" +
                        "</form>", true);

        javaMailSender.send(mimeMessage);

        MailAuthDto mailAuthDto = new MailAuthDto(email, String.valueOf(authNo), false);
        EmailAuthEntity emailAuthEntity = modelMapper.map(mailAuthDto, EmailAuthEntity.class);
        return emailAuthRepository.save(emailAuthEntity);
    }

    public Boolean checkMailCode(String email, String code) throws NullPointerException {
        EmailAuthEntity emailAuth = emailAuthRepository.findByEmailAndCode(email, code)
                .filter(e -> !"".equals(e.getEmail()))
                .orElseThrow(() -> new NullPointerException("해당 메일과 코드가 인증되지 않았습니다."));

        if (LocalDateTime.now().isBefore(emailAuth.getCreatedDate().plusMinutes(10))) emailAuth.changeMailUse(false);
        return emailAuth.isUse();



    }

    public EmailAuthEntity authenticationMailCode(String email, String code) {
        EmailAuthEntity emailAuth = emailAuthRepository.findByEmailAndCode(email, code)
                .filter(e -> !"".equals(e.getEmail()))
                .orElseThrow(() -> new NullPointerException("해당 이메일과 코드를 확인해주세요."));
        emailAuth.changeMailUse(true);
        emailAuthRepository.save(emailAuth);
        return emailAuth;
    }
}
