package com.github.sankowskiwojciech.bookhunter.model.author.exception;

import com.github.sankowskiwojciech.bookhunter.model.exception.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = ErrorMessages.AUTHOR_NOT_FOUND)
public class AuthorNotFoundException extends RuntimeException {
}
