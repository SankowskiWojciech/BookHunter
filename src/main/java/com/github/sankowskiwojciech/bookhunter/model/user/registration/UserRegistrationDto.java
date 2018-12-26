package com.github.sankowskiwojciech.bookhunter.model.user.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserRegistrationDto {

    private final String userName;
    private final String password;
    private final String matchingPassword;
    private final String emailAddress;
}
