package com.example.petever.account.service;

import com.example.petever.account.dto.UserDto;
import com.example.petever.account.entity.UserEntity;
import com.example.petever.account.repository.UserRepository;
import com.example.petever.exception.InvalidParameterException;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserDto login(@RequestBody UserDto userDto) {
        UserEntity userEntity = userRepository.findByEmail(userDto.getEmail())
                .filter(user -> user.getPassword().equals(user.getPassword()))
                .orElseThrow(() -> new InvalidParameterException("이메일과 비밀번호를 확인하세요", HttpStatus.BAD_REQUEST.value()));

        return modelMapper.map(userEntity, UserDto.class);
    }
}
