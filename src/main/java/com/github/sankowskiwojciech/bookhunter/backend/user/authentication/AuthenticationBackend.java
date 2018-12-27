package com.github.sankowskiwojciech.bookhunter.backend.user.authentication;

import com.github.sankowskiwojciech.bookhunter.model.user.authentication.UserAuthentication;

import java.util.Optional;

public interface AuthenticationBackend {

    Optional<UserAuthentication> findUserByUsername(String userName);
}
