package com.github.sankowskiwojciech.bookhunter.backend.user.registration;

import com.github.sankowskiwojciech.bookhunter.model.user.registration.UserRegistration;

public interface RegistrationBackend {

    UserRegistration registerUser(UserRegistration userRegistration);

    Boolean isUserWithGivenUserNameAlreadyRegistered(String userName);

    Boolean isUserWithGivenEmailAddressAlreadyRegistered(String emailAddress);
}
