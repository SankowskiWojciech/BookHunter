package com.github.sankowskiwojciech.bookhunter.model.book.excetion;

import com.github.sankowskiwojciech.bookhunter.model.exception.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = ErrorMessages.BOOK_NOT_FOUND)
public class BookNotFoundException extends RuntimeException {
}
