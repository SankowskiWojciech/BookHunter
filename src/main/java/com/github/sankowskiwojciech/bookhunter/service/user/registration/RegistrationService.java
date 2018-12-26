package com.github.sankowskiwojciech.bookhunter.service.user.registration;

import com.github.sankowskiwojciech.bookhunter.model.user.registration.UserRegistration;

public interface RegistrationService {
    UserRegistration registerUser(UserRegistration userRegistration);
}
