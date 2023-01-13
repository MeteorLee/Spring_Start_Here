package com.login.services;

import com.login.model.RealUser;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class LoginService {


    private final RealUser realUser;

    public LoginService(RealUser realUser) {
        this.realUser = realUser;
    }

    private String username;
    private String password;


    public boolean IsMyUser() {
        String un = this.getUsername();
        String ps = this.getPassword();

        boolean isTrue = false;

        if ("koko".equals(un) && "123".equals(ps)) {
            realUser.setName(un);
            isTrue = true;
        }

        return isTrue;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
