package com.github.sankowskiwojciech.bookhunter.model.user.registration.exception;

import com.github.sankowskiwojciech.bookhunter.model.exception.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidUserNameFormatException extends RuntimeException {
    public InvalidUserNameFormatException() {
        super(ErrorMessages.INVALID_USER_NAME_FORMAT);
    }
}
