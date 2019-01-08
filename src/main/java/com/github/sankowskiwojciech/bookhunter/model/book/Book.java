package com.github.sankowskiwojciech.bookhunter.model.book;

import com.github.sankowskiwojciech.bookhunter.model.author.AuthorBasicInformation;
import com.github.sankowskiwojciech.bookhunter.model.book.rating.BookRating;
import com.github.sankowskiwojciech.bookhunter.model.category.Category;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

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
    private final Set<Category> categories;
    private final String description;
    private final String countryCode;
    private final byte[] coverImage;
    private final List<AuthorBasicInformation> authors;
    private final BookRating bookRating;
}
