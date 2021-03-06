package com.github.sankowskiwojciech.bookhunter.model.author;

import com.github.sankowskiwojciech.bookhunter.model.book.BookBasicInformation;
import com.github.sankowskiwojciech.bookhunter.model.category.Category;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Author {

    private final Long id;
    private final String name;
    private final String surname;
    private final String birthYear;
    private final String deathYear;
    private final byte[] profilePhoto;
    private final String description;
    private final Set<Category> categories;
    private final List<BookBasicInformation> books;
}
