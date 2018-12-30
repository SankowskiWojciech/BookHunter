package com.github.sankowskiwojciech.bookhunter.model.book;

import com.github.sankowskiwojciech.bookhunter.model.author.AuthorBasicInformation;
import com.github.sankowskiwojciech.bookhunter.model.genre.Genre;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "isbn")
public class Book {

    private final String isbn;
    private final String title;
    private final String originalTitle;
    private final String releaseYear;
    private final Set<Genre> genres;
    private final String description;
    private final String countryCode;
    private final InputStream coverImage;
    private final List<AuthorBasicInformation> authors;
}
