package com.github.sankowskiwojciech.bookhunter.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = ErrorMessages.MISSING_BODY_REQUEST)
public class MissingBodyRequestException extends RuntimeException {
}
