package com.github.sankowskiwojciech.bookhunter.model.book;

import com.github.sankowskiwojciech.bookhunter.model.author.AuthorBasicInformation;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "isbn")
public class BookResponse {

    private final String isbn;
    private final String title;
    private final String originalTitle;
    private final String releaseYear;
    private final String categories;
    private final String description;
    private final String country;
    private final String coverImage;
    private final List<AuthorBasicInformation> authors;
    private final Integer numberOfRates;
    private final Double averageRate;
}
