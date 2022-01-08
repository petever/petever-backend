package com.example.petever.domain.account;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SignTest {

    @Test
    @DisplayName("이메일은 빈값이나 널이 들어오면 안된다")
    void case1() {
        String email = null;
        Sign sign = new Sign();
        boolean result = sign.isEmpty(email);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("이메일 형식에 맞지 않는 값은 들어오면 안된다.")
    void case2() {
        String email = "rumor1993@flow.team";
        Sign sign = new Sign();
        boolean result = sign.isValidEmail(email);
        assertThat(result).isTrue();
    }


}