package com.github.sankowskiwojciech.bookhunter.model.user.registration.exception.registration;

import com.github.sankowskiwojciech.bookhunter.model.user.registration.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = ErrorMessages.PASSWORD_MISMATCH)
public class PasswordMismatchException extends RuntimeException {
}
