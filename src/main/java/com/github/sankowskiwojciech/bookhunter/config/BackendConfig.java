package com.github.sankowskiwojciech.bookhunter.config;

import com.github.sankowskiwojciech.bookhunter.backend.user.authentication.AuthenticationBackend;
import com.github.sankowskiwojciech.bookhunter.backend.user.authentication.AuthenticationBackendImpl;
import com.github.sankowskiwojciech.bookhunter.backend.user.registration.RegistrationBackend;
import com.github.sankowskiwojciech.bookhunter.backend.user.registration.RegistrationBackendImpl;
import com.github.sankowskiwojciech.bookhunter.backend.repository.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackendConfig {

    @Autowired
    private UserAuthenticationRepository userAuthenticationRepository;

    @Bean
    public RegistrationBackend registrationBackend() {
        return new RegistrationBackendImpl(userAuthenticationRepository);
    }

    @Bean
    public AuthenticationBackend authenticationBackend() {
        return new AuthenticationBackendImpl(userAuthenticationRepository);
    }
}
