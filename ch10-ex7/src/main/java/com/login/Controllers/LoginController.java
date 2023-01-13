package com.login.Controllers;

import com.login.services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @GetMapping("")
    public String home() {
        return "login.html";
    }

    @PostMapping("")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        loginService.setUsername(username);
        loginService.setPassword(password);
        boolean islogin = loginService.IsMyUser();

        if (islogin) {
            return "redirect:/main";
        }
        model.addAttribute("message", "실패!");
        return "login.html";

    }
}
