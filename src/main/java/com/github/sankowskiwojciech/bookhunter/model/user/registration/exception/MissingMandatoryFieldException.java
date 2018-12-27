package com.github.sankowskiwojciech.bookhunter.model.user.registration.exception;

import com.github.sankowskiwojciech.bookhunter.model.user.registration.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = ErrorMessages.MISSING_MANDATORY_FIELD)
public class MissingMandatoryFieldException extends RuntimeException {
}