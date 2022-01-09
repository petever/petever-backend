package com.example.petever.account.service;

import com.example.petever.account.domain.Auth;
import com.example.petever.account.domain.Email;
import com.example.petever.account.domain.Nickname;
import com.example.petever.account.domain.Password;
import com.example.petever.account.dto.UserDto;
import com.example.petever.account.entity.EmailAuthEntity;
import com.example.petever.account.repository.EmailAuthRepository;
import com.example.petever.account.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final UserRepository accountRepository;
    private final EmailAuthRepository emailAuthRepository;

    public String signIn(UserDto userDto) {
        if (!Email.isValid(userDto.getEmail())) return "이메일을 확인해주세요";
        if (!Password.isValid(userDto.getPassword())) return "비밀번호를 확인해주세요";
        if (!Nickname.isValid(userDto.getName())) return "이메일을 확인해주세요";

        EmailAuthEntity emailAuthEntity = emailAuthRepository.findById(userDto.getEmail()).get();
        if (!Auth.isValid(userDto.getCode(), emailAuthEntity.getCode())) return "이메일 인증코드를 확인하세요";
        return "OK";
    }
}
