package com.github.sankowskiwojciech.bookhunter.backend.user.authentication;

import com.github.sankowskiwojciech.bookhunter.model.user.authentication.UserAuthentication;

public interface AuthenticationBackend {

    UserAuthentication findUserByUsername(String userName);
}
