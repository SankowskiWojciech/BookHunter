package com.github.sankowskiwojciech.bookhunter.model.user.registration.exception;

import com.github.sankowskiwojciech.bookhunter.model.exception.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MissingMandatoryFieldException extends RuntimeException {
    public MissingMandatoryFieldException(String fieldName) {
        super(String.format(ErrorMessages.MISSING_MANDATORY_FIELD, fieldName));
    }
}
