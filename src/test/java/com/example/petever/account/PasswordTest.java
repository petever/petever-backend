package com.example.petever.account;

import com.example.petever.account.domain.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PasswordTest {

    @Test
    @DisplayName("비밀번호는 빈값이나 널이 들어오면 안된다.")
    void 비밀번호는_빈값이나_널이_들어오면_안된다() {
        String pw = "";
        Password password = new Password();
        assertThat(password.isEmpty(pw)).isTrue();
    }

    @Test
    @DisplayName("비밀번호는 형식에 맞지 않는 값은 들어오면 안된다.")
    void 비밀번호는_형식에_맞지_않는_값은_들어오면_안된다() {
        String pw = "1234123s4";
        Password password = new Password();
        assertThat(password.isValid(pw)).isTrue();
    }
}