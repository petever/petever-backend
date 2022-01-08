package com.example.petever.domain.account;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @Test
    @DisplayName("비밀번호는 빈값이나 널이 들어오면 안된다.")
    void case1() {
        String pw = "";
        Password password = new Password();
        assertThat(password.isEmpty(pw)).isTrue();
    }

    @Test
    @DisplayName("비밀번호는 형식에 맞지 않는 값은 들어오면 안된다.")
    void case2() {
        String pw = "1234123s4";
        Password password = new Password();
        assertThat(password.isValid(pw)).isTrue();
    }
}