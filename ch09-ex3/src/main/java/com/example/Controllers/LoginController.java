package com.example.Controllers;

import com.example.Model.LoginProcessor;
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
    public String home() {
        return "login.html";
    }

    @PostMapping("/")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        boolean isLogin = loginProcessor.login();

        if (isLogin == false) {
            model.addAttribute("message", "잘 못 입력하셨습니다.");
            return "login.html";
        }

        model.addAttribute("username", username);
        return "redirect:/main";
    }
}
