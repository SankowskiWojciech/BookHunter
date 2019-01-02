package com.github.sankowskiwojciech.bookhunter.model.book;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookBasicInformation {
    private final String isbn;
    private final String title;
}
