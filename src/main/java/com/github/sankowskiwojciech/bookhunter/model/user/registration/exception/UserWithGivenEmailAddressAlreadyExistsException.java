package com.github.sankowskiwojciech.bookhunter.model.user.registration.exception;

import com.github.sankowskiwojciech.bookhunter.model.exception.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserWithGivenEmailAddressAlreadyExistsException extends RuntimeException {
    public UserWithGivenEmailAddressAlreadyExistsException() {
        super(ErrorMessages.USER_WITH_GIVEN_EMAIL_ADDRESS_ALREADY_EXISTS);
    }
}
