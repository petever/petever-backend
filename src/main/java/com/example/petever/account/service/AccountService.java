package com.example.petever.account.service;

import com.example.petever.exception.InvalidParameterException;
import com.example.petever.util.Email;
import com.example.petever.util.Nickname;
import com.example.petever.util.Password;
import com.example.petever.account.dto.UserDto;
import com.example.petever.account.entity.UserEntity;
import com.example.petever.account.repository.EmailAuthRepository;
import com.example.petever.account.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new InvalidParameterException("인증받지 못한 이메일입니다.", HttpStatus.BAD_REQUEST.value()));

        accountRepository.save(modelMapper.map(userDto, UserEntity.class));
        return "OK";
    }

    public Boolean checkMail(String email) {
        UserEntity userEntity = accountRepository.findByEmail(email)
                .filter(user -> user != null)
                .orElseThrow(() -> new InvalidParameterException("이메일을 확인하세요", HttpStatus.BAD_REQUEST.value()));

        if ("".equals(userEntity.getEmail())) return true;
        return false;
    }
}
