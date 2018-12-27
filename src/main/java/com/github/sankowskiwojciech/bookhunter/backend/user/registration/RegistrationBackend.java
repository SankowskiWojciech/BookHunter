package com.github.sankowskiwojciech.bookhunter.backend.user.registration;

import com.github.sankowskiwojciech.bookhunter.model.user.authentication.UserAuthentication;

public interface RegistrationBackend {

    UserAuthentication registerUser(UserAuthentication userAuthentication);

    Boolean isUserWithGivenUserNameAlreadyRegistered(String userName);

    Boolean isUserWithGivenEmailAddressAlreadyRegistered(String emailAddress);
}
