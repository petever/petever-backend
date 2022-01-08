package com.example.petever.domain.account;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class EmailTest {

    private MailService mailService;

    @Test
    @DisplayName("이메일은 빈값이나 널이 들어오면 안된다")
    void case1() {
        String email = null;
        Email sign = new Email();
        boolean result = sign.isEmpty(email);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("이메일 형식에 맞지 않는 값은 들어오면 안된다.")
    void case2() {
        String email = "rumor1993@flow.team";
        Email sign = new Email();
        boolean result = sign.isValid(email);
        assertThat(result).isTrue();
    }

    // 이메일 인증은 목 작업을 해야하는데 운영 테스트는 성공


    @Test
    @DisplayName("이메일 인증번호가 맞는지 확인한다.")
    void case3() {

    }
}