package com.github.sankowskiwojciech.bookhunter.model.user.registration.exception.registration;

import com.github.sankowskiwojciech.bookhunter.model.user.registration.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String field) {
        super(String.format(ErrorMessages.USER_ALREADY_EXISTS, field));
    }
}
