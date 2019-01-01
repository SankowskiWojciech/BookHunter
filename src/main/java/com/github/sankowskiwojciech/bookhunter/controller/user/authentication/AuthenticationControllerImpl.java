package com.github.sankowskiwojciech.bookhunter.controller.user.authentication;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationControllerImpl {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login/login";
    }
}
