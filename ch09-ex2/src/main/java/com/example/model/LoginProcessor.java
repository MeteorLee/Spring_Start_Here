package com.example.model;

import com.example.Services.LoggedUserManagementService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private final LoggedUserManagementService loggedUserManagementService;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }
    private String name;
    private String password;

    public boolean login() {
        String username = this.getName();
        String password = this.getPassword();

        boolean loginResult = false;

        if ("Koko".equals(username) && ("1234".equals(password))) {
            loginResult = true;
            loggedUserManagementService.setUsername(username);
        }

        return loginResult;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
