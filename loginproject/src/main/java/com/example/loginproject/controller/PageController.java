package com.example.loginproject.controller;

import com.example.loginproject.service.AuthService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final AuthService authService;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session) {
        if (authService.authenticate(username, password)) {
            session.setAttribute("user", username);
            return "redirect:/main";
        } else {
            return "redirect:/login.html?error";
        }
    }
    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestParam String username,
                           @RequestParam String password) {
        authService.register(username, password);
        return "회원가입 성공";
    }

    @GetMapping("/main")
    @ResponseBody
    public String main(HttpSession session) {
        Object user = session.getAttribute("user");
        return (user == null) ? "로그인 필요" : "안녕하세요, " + user + "님!";
    }
}
