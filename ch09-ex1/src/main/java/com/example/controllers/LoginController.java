package com.example.controllers;

import com.example.service.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet(Model model) {
        return "login.html";
    }


    @PostMapping("/")
    public String loginPost(Model model,
                            @RequestParam String username,
                            @RequestParam String password) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        boolean loggedIn = false;

        loggedIn = loginProcessor.login();

        if (loggedIn) {
            model.addAttribute("message", "로그인 성공");
        } else {
            model.addAttribute("message", "로그인 실패");
        }


        return "login.html";
    }
}
