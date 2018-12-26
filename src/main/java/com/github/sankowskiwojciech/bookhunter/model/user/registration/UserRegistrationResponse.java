package com.github.sankowskiwojciech.bookhunter.model.user.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserRegistrationResponse {

    private String username;
    private String emailAddress;
}
