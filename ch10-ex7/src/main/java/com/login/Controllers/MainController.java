package com.login.Controllers;

import com.login.model.RealUser;
import com.login.services.LogoutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/main")
public class MainController {

    private final LogoutService logoutService;
    private final RealUser realUser;

    public MainController(LogoutService logoutService, RealUser realUser) {
        this.logoutService = logoutService;
        this.realUser = realUser;
    }

    @GetMapping("")
    public String main(@RequestParam(required = false) String logout,
                       Model model) {

        if (logout !=null) {
            logoutService.Logout();
        }


        String username = realUser.getName();

        if (username == null) {
            return "redirect:/login";
        }
        model.addAttribute("name", username);
        return "main.html";
    }


}
