package com.github.sankowskiwojciech.bookhunter.backend.user.authentication;

import com.github.sankowskiwojciech.bookhunter.backend.repository.UserAuthenticationRepository;
import com.github.sankowskiwojciech.bookhunter.backend.user.authentication.transformer.UserAuthenticationEntityToUserAuthentication;
import com.github.sankowskiwojciech.bookhunter.model.user.authentication.UserAuthentication;
import com.github.sankowskiwojciech.bookhunter.model.user.authentication.db.UserAuthenticationEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticationBackendImpl implements AuthenticationBackend {

    private final UserAuthenticationRepository userAuthenticationRepository;

    @Override
    public UserAuthentication findUserByUsername(String userName) {
        UserAuthenticationEntity userAuthenticationEntity = userAuthenticationRepository.findByUserName(userName);
        return new UserAuthenticationEntityToUserAuthentication().apply(userAuthenticationEntity);
    }
}
