package com.github.sankowskiwojciech.bookhunter.model.user.authentication.exception;

import com.github.sankowskiwojciech.bookhunter.model.exception.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = ErrorMessages.INVALID_USERNAME_OR_PASSWORD)
public class UnauthorizedException extends RuntimeException {
}
