package com.github.sankowskiwojciech.bookhunter.model.author;

import com.github.sankowskiwojciech.bookhunter.model.genre.Genre;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.InputStream;
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
    private final InputStream image;
    private final String description;
    private final Set<Genre> genres;
}