package com.example.petever.account.controller;

import com.example.petever.account.dto.UserDto;
import com.example.petever.account.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto, HttpServletRequest request) {
        UserDto loginUser = loginService.login(userDto);
        HttpSession session = request.getSession();
        session.setAttribute("users", loginUser);
        return "";
    }

    @PostMapping("/logout")
    public String logout(@RequestBody UserDto userDto, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) session.invalidate();
        return "로그아웃";
    }
}
