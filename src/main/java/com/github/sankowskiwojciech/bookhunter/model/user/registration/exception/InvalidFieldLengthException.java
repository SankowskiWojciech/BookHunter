package com.github.sankowskiwojciech.bookhunter.model.user.registration.exception;

import com.github.sankowskiwojciech.bookhunter.model.exception.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidFieldLengthException extends RuntimeException {
    public InvalidFieldLengthException(String field, Integer minLength, Integer maxLength) {
        super(String.format(ErrorMessages.INVALID_LENGTH, field, minLength, maxLength));
    }
}
