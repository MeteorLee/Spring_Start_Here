package com.login.services;

import com.login.model.RealUser;
import org.springframework.stereotype.Service;

@Service
public class LogoutService {
    private final RealUser realUser;

    public LogoutService(RealUser realUser) {
        this.realUser = realUser;
    }

    public void Logout() {
        realUser.setName(null);
    }


}
