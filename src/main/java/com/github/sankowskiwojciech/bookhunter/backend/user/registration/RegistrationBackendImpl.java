package com.github.sankowskiwojciech.bookhunter.backend.user.registration;

import com.github.sankowskiwojciech.bookhunter.backend.repository.UserAuthenticationRepository;
import com.github.sankowskiwojciech.bookhunter.model.user.registration.UserRegistration;
import com.github.sankowskiwojciech.bookhunter.model.user.registration.db.UserRegistrationEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegistrationBackendImpl implements RegistrationBackend {

    private final UserAuthenticationRepository userAuthenticationRepository;

    @Override
    public UserRegistration registerUser(UserRegistration userRegistration) {
        UserRegistrationEntity userRegistrationEntity = new UserRegistrationEntity(userRegistration.getUserName(), userRegistration.getPassword(), userRegistration.getEmailAddress());
        UserRegistrationEntity registeredUser = userAuthenticationRepository.saveAndFlush(userRegistrationEntity);
        return new UserRegistration(registeredUser.getUserName(), registeredUser.getPassword(), registeredUser.getEmailAddress());
    }

    @Override
    public Boolean isUserWithGivenUserNameAlreadyRegistered(String userName) {
        return userAuthenticationRepository.existsByUserName(userName);
    }

    @Override
    public Boolean isUserWithGivenEmailAddressAlreadyRegistered(String emailAddress) {
        return userAuthenticationRepository.existsByEmailAddress(emailAddress);
    }
}
