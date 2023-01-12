package com.example.Controllers;

import com.example.model.LoginProcessor;
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
    public String home(Model model) {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {
        loginProcessor.setName(username);
        loginProcessor.setPassword(password);

        boolean loggenIn = false;
        loggenIn = loginProcessor.login();

        if (loggenIn == true) {
            model.addAttribute("message", "로그인 되었습니니다");
            return "main.html";
        }else {

            model.addAttribute("message", "로그인 실패!");
            return "login.html";
        }
    }
}
