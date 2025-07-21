package org.dnyanyog.services;

import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepo userRepo;

    public LoginResponse login(String loginName, String pasword) {
        LoginResponse response = new LoginResponse();

        if (loginName == null || pasword == null) {
            response.setResponseCode("0911");
            response.setResponseMessage("LoginName and password both are mandatory");
            return response;
        }

        try {
            Users userFromDb = userRepo.findByLoginNameAndPasword(loginName, pasword);

            if (userFromDb != null) {
                response.setResponseCode("0000");
                response.setResponseMessage("Login Successful");
            } else {
                response.setResponseCode("0911");
                response.setResponseMessage("LoginName and password do not match");
            }
        } catch (Exception e) {
            response.setResponseCode("0911");
            response.setResponseMessage("Internal server error occurred");
            e.printStackTrace();
        }

        return response;
    }
}
