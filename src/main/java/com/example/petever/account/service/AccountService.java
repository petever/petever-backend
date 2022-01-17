package com.example.petever.account.service;

import com.example.petever.account.domain.Auth;
import com.example.petever.account.domain.Email;
import com.example.petever.account.domain.Nickname;
import com.example.petever.account.domain.Password;
import com.example.petever.account.dto.UserDto;
import com.example.petever.account.entity.EmailAuthEntity;
import com.example.petever.account.entity.UserEntity;
import com.example.petever.account.repository.EmailAuthRepository;
import com.example.petever.account.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final UserRepository accountRepository;
    private final EmailAuthRepository emailAuthRepository;
    private final ModelMapper modelMapper;

    public String signIn(UserDto userDto) {
        if (!Email.isValid(userDto.getEmail())) return "이메일을 확인해주세요";
        if (!Password.isValid(userDto.getPassword())) return "비밀번호를 확인해주세요";
        if (!Nickname.isValid(userDto.getName())) return "이메일을 확인해주세요";
        emailAuthRepository.findFirstByEmailOrderByCreatedDateDesc(userDto.getEmail())
                .filter(e -> e.isUse() == true)
                .orElseThrow(() -> new IllegalArgumentException("인증받지 못한 이메일입니다."));


        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        accountRepository.save(userEntity);
        return "OK";
    }

    public Boolean checkMail(String email) {
        UserEntity userEntity = accountRepository.findByEmail(email)
                .filter(user -> user != null)
                .orElseThrow(() -> new IllegalStateException("이메일을 확인하세요"));

        if ("".equals(userEntity.getEmail())) return true;
        return false;
    }
}
