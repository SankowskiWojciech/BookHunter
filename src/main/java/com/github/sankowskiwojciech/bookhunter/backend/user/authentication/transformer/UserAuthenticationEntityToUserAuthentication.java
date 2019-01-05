package com.github.sankowskiwojciech.bookhunter.backend.user.authentication.transformer;

import com.github.sankowskiwojciech.bookhunter.model.user.authentication.UserAuthentication;
import com.github.sankowskiwojciech.bookhunter.model.user.authentication.db.UserAuthenticationEntity;

import java.util.function.Function;

public class UserAuthenticationEntityToUserAuthentication implements Function<UserAuthenticationEntity, UserAuthentication> {
    @Override
    public UserAuthentication apply(UserAuthenticationEntity userAuthenticationEntity) {
        if (userAuthenticationEntity != null) {
            return new UserAuthentication(
                    userAuthenticationEntity.getUserName(),
                    userAuthenticationEntity.getPassword(),
                    userAuthenticationEntity.getEmailAddress()
            );
        }
        return null;
    }
}
