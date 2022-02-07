package com.example.petever.account.controller;

import com.example.petever.account.dto.LoginDto;
import com.example.petever.account.dto.UserDto;
import com.example.petever.account.service.LoginService;
import com.example.petever.session.SessionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "https://petever.pet", allowedHeaders = "*", allowCredentials = "true")
public class LoginController {
    private final LoginService loginService;
    private final SessionManager sessionManager;

    @PostMapping("/login")
    public LoginDto login(@RequestBody LoginDto loginDto, HttpServletRequest request, HttpServletResponse response) {
        LoginDto loginUser = loginService.login(loginDto);
        HttpSession session = request.getSession();
        session.setAttribute("users", loginUser);
        return loginUser;
    }

    @PostMapping("/logout")
    public String logout(@RequestBody UserDto userDto, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) session.invalidate();
        return "로그아웃";
    }
}
