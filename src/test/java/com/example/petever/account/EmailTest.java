package com.example.petever.account;

import com.example.petever.account.util.Email;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class EmailTest {

    @Test
    @DisplayName("이메일은 빈값이나 널이 들어오면 안된다")
    void 이메일은_빈값이나_널이_들어오면_안된다() {
        String email = "";
        boolean result = Email.isEmpty(email);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("이메일 형식에 맞지 않는 값은 들어오면 안된다.")
    void 이메일_형식에_맞지_않는_값은_들어오면_안된다() {
        String email = "rumor1993@flow.team";
        boolean result = Email.isValid(email);
        assertThat(result).isTrue();
    }
}