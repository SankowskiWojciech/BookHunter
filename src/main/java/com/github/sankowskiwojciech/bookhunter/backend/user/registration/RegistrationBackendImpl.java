package com.github.sankowskiwojciech.bookhunter.backend.user.registration;

import com.github.sankowskiwojciech.bookhunter.backend.repository.UserAuthenticationRepository;
import com.github.sankowskiwojciech.bookhunter.model.user.authentication.UserAuthentication;
import com.github.sankowskiwojciech.bookhunter.model.user.authentication.db.UserAuthenticationEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegistrationBackendImpl implements RegistrationBackend {

    private final UserAuthenticationRepository userAuthenticationRepository;

    @Override
    public UserAuthentication registerUser(UserAuthentication userAuthentication) {
        UserAuthenticationEntity userAuthenticationEntity = new UserAuthenticationEntity(userAuthentication.getUsername(), userAuthentication.getPassword(), userAuthentication.getEmailAddress());
        UserAuthenticationEntity registeredUser = userAuthenticationRepository.saveAndFlush(userAuthenticationEntity);
        return new UserAuthentication(registeredUser.getUserName(), registeredUser.getPassword(), registeredUser.getEmailAddress());
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
