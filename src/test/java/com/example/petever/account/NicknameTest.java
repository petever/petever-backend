package com.example.petever.account;

import com.example.petever.account.util.Nickname;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NicknameTest {
    @Test
    @DisplayName("닉네임 빈값이나 널이 들어오면 안된다")
    void 닉네임_빈값이나_널이_들어오면_안된다() {
        String name = "";
        Nickname nickname = new Nickname();
        boolean result = nickname.isEmpty(name);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("숫자, 영어, 한국어와 언더스코어를 허용하며 최소 2자 이상의 닉네임")
    void 숫자_영어_한국어와_언더스코어를_허용하며_최소_2자_이상의_닉네임() {
        String name = "문혁_a12";
        Nickname nickname = new Nickname();
        boolean result = nickname.isValid(name);
        assertThat(result).isTrue();
    }
}