package com.github.sankowskiwojciech.bookhunter.model.user.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserAuthentication {
    private String userName;
    private String password;
    private String emailAddress;
}
