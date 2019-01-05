package com.github.sankowskiwojciech.bookhunter.service.user.authentication;

import com.github.sankowskiwojciech.bookhunter.backend.user.authentication.AuthenticationBackend;
import com.github.sankowskiwojciech.bookhunter.model.user.authentication.exception.UnauthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AuthenticationBackend authenticationBackend;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDetails userDetails = authenticationBackend.findUserByUsername(username);
        if (userDetails == null) {
            throw new UnauthorizedException();
        }
        return userDetails;
    }
}
