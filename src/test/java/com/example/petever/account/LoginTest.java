package com.example.petever.account;

import com.example.petever.account.dto.UserDto;
import com.example.petever.account.entity.UserEntity;
import com.example.petever.account.repository.UserRepository;
import com.example.petever.account.service.AccountService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class LoginTest {

    @Autowired
    private AccountService accountService;

    @Test
    @DisplayName("올바른 회원정보입력")
    void loginCase1(){
        UserDto userDto = new UserDto("test1@naver.com", "pass1");
        String result = accountService.logIn(userDto);
        assertThat(result).isEqualTo("OK");
    }

    @Test
    @DisplayName("올바르지 않은 회원정보입력")
    void loginCase2(){
        UserDto userDto = new UserDto("test1@naver.com", "pass2");
        String result = accountService.logIn(userDto);
        assertThat(result).isEqualTo("FAIL");
    }


}
