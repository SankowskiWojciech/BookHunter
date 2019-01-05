package com.github.sankowskiwojciech.bookhunter.model.author;

import com.github.sankowskiwojciech.bookhunter.model.book.BookBasicInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class AuthorResponse {

    private final Long id;
    private final String name;
    private final String surname;
    private final String birthYear;
    private final String deathYear;
    private final String profilePhoto;
    private final String description;
    private final String categories;
    private final List<BookBasicInformation> books;
}
