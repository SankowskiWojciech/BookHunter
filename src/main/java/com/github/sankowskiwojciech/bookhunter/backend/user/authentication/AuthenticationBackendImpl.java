package com.github.sankowskiwojciech.bookhunter.backend.user.authentication;

import com.github.sankowskiwojciech.bookhunter.backend.repository.UserAuthenticationRepository;
import com.github.sankowskiwojciech.bookhunter.model.user.authentication.UserAuthentication;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class AuthenticationBackendImpl implements AuthenticationBackend {

    private final UserAuthenticationRepository userAuthenticationRepository;

    @Override
    public Optional<UserAuthentication> findUserByUsername(String userName) {
        return userAuthenticationRepository.findByUserName(userName);
    }
}
