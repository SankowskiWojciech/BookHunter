package com.github.sankowskiwojciech.bookhunter.service.user.registration;

import com.github.sankowskiwojciech.bookhunter.model.user.authentication.UserAuthentication;

public interface RegistrationService {
    UserAuthentication registerUser(UserAuthentication userAuthentication);
}
