package com.github.sankowskiwojciech.bookhunter.model.user.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserRegistration {
    private String userName;
    private String password;
    private String emailAddress;
}
