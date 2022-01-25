package com.example.petever.account.service;

import com.example.petever.account.dto.MailAuthDto;
import com.example.petever.account.entity.EmailAuthEntity;
import com.example.petever.account.repository.EmailAuthRepository;
import lombok.RequiredArgsConstructor;
import org.codehaus.groovy.util.StringUtil;
import org.modelmapper.ModelMapper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

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
    private final TemplateEngine templateEngine;

    public MailAuthDto sendMailCode(String email) throws MessagingException {
        List<String> toUserList = new ArrayList<>();
        toUserList.add(email);

        int toUserSize = toUserList.size();
        int authNo = (int)(Math.random() * (99999 - 10000 + 1)) + 10000;

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper simpleMailMessage = new MimeMessageHelper(mimeMessage, "utf-8");

        Context context = new Context();
        context.setVariable("code", authNo);
        context.setVariable("email", email);
        String process = templateEngine.process("sendMail.html", context);

        simpleMailMessage.setTo(toUserList.toArray(new String[toUserSize]));
        simpleMailMessage.setSubject("Petever 회원가입 인증 메일입니다");
        simpleMailMessage.setText(process, true);
        javaMailSender.send(mimeMessage);

        MailAuthDto mailAuthDto = new MailAuthDto(email, String.valueOf(authNo), false);
        EmailAuthEntity emailAuthEntity = modelMapper.map(mailAuthDto, EmailAuthEntity.class);
        emailAuthRepository.save(emailAuthEntity);
        return modelMapper.map(emailAuthEntity, MailAuthDto.class);
    }

    public String authenticationMailCode(String email, String code) throws NullPointerException {
        EmailAuthEntity emailAuth = emailAuthRepository.findByEmailAndCode(email, code)
                .filter(e -> !"".equals(e.getEmail()))
                .orElse(null);

        if (emailAuth == null) return "인증이 만료되었습니다.";
        LocalDateTime createDate = "".equals(emailAuth.getCreatedDate()) ? emailAuth.getModifiedDate() : emailAuth.getCreatedDate();
        if (LocalDateTime.now().isBefore(createDate.plusMinutes(10))) emailAuth.changeMailUse(false);
        emailAuth.changeMailUse(true);
        emailAuthRepository.save(emailAuth);
        return emailAuth.isUse() ? "인증이 완료되었습니다." : "인증이 만료되었습니다.";
    }

    public Boolean checkAuthMail(String email) throws NullPointerException {
        EmailAuthEntity emailAuth = emailAuthRepository.findFirstByEmailOrderByCreatedDateDesc(email)
                .orElseThrow(() -> new IllegalArgumentException());
        return emailAuth.isUse();

    }
}
