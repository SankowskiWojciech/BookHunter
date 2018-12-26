package com.github.sankowskiwojciech.bookhunter.service.user.registration;

import com.github.sankowskiwojciech.bookhunter.backend.user.registration.RegistrationBackend;
import com.github.sankowskiwojciech.bookhunter.model.user.registration.UserRegistration;
import com.github.sankowskiwojciech.bookhunter.model.user.registration.exception.registration.UserAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationBackend registrationBackend;
    private final PasswordEncoder passwordEncoder;

    private static final String USER_NAME = "user name";
    private static final String EMAIL_ADDRESS = "email address";

    @Override
    public UserRegistration registerUser(UserRegistration userRegistration) {
        validateIfUserIsAlreadyRegistered(userRegistration.getUserName(), userRegistration.getEmailAddress());
        String encodedPassword = encodePassword(userRegistration.getPassword());
        userRegistration.setPassword(encodedPassword);
        return registrationBackend.registerUser(userRegistration);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    private void validateIfUserIsAlreadyRegistered(String username, String emailAddress) {
        if (registrationBackend.isUserWithGivenUserNameAlreadyRegistered(username)) {
            throw new UserAlreadyExistsException(USER_NAME);
        }
        if (registrationBackend.isUserWithGivenEmailAddressAlreadyRegistered(emailAddress)) {
            throw new UserAlreadyExistsException(EMAIL_ADDRESS);
        }
    }
}
