package com.github.sankowskiwojciech.bookhunter.service.user.authentication;

import com.github.sankowskiwojciech.bookhunter.backend.user.authentication.AuthenticationBackend;
import com.github.sankowskiwojciech.bookhunter.model.user.authentication.UserAuthentication;
import com.github.sankowskiwojciech.bookhunter.model.user.authentication.exception.UnauthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AuthenticationBackend authenticationBackend;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<UserAuthentication> userAuthenticationOptional = authenticationBackend.findUserByUsername(username);
        if (!userAuthenticationOptional.isPresent()) {
            throw new UnauthorizedException();
        }
        return userAuthenticationOptional.get();
    }
}
