package com.github.sankowskiwojciech.bookhunter.config;

import com.github.sankowskiwojciech.bookhunter.backend.user.authentication.AuthenticationBackend;
import com.github.sankowskiwojciech.bookhunter.backend.user.registration.RegistrationBackend;
import com.github.sankowskiwojciech.bookhunter.service.user.authentication.UserDetailsServiceImpl;
import com.github.sankowskiwojciech.bookhunter.service.user.registration.RegistrationService;
import com.github.sankowskiwojciech.bookhunter.service.user.registration.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ServiceConfig {

    @Autowired
    private RegistrationBackend registrationBackend;

    @Autowired
    private AuthenticationBackend authenticationBackend;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public RegistrationService registrationService() {
        return new RegistrationServiceImpl(registrationBackend, passwordEncoder);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(authenticationBackend);
    }
}
