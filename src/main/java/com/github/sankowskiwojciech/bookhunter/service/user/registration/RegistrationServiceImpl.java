package com.github.sankowskiwojciech.bookhunter.service.user.registration;

import com.github.sankowskiwojciech.bookhunter.backend.user.registration.RegistrationBackend;
import com.github.sankowskiwojciech.bookhunter.model.user.authentication.UserAuthentication;
import com.github.sankowskiwojciech.bookhunter.model.user.registration.exception.UserWithGivenEmailAddressAlreadyExistsException;
import com.github.sankowskiwojciech.bookhunter.model.user.registration.exception.UserWithGivenUserNameAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationBackend registrationBackend;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserAuthentication registerUser(UserAuthentication userAuthentication) {
        validateIfUserIsAlreadyRegistered(userAuthentication.getUsername(), userAuthentication.getEmailAddress());
        String encodedPassword = passwordEncoder.encode(userAuthentication.getPassword());
        userAuthentication.setPassword(encodedPassword);
        return registrationBackend.registerUser(userAuthentication);
    }

    private void validateIfUserIsAlreadyRegistered(String username, String emailAddress) {
        if (registrationBackend.isUserWithGivenUserNameAlreadyRegistered(username)) {
            throw new UserWithGivenUserNameAlreadyExistsException();
        }
        if (registrationBackend.isUserWithGivenEmailAddressAlreadyRegistered(emailAddress)) {
            throw new UserWithGivenEmailAddressAlreadyExistsException();
        }
    }
}
