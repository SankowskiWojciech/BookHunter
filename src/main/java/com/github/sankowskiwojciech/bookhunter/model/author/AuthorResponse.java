package com.github.sankowskiwojciech.bookhunter.model.author;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.InputStream;
import java.util.Set;

@AllArgsConstructor
@Getter
public class AuthorResponse {

    private final Long id;
    private final String name;
    private final String surname;
    private final String birthYear;
    private final String deathYear;
    private final InputStream image;
    private final String description;
    private final Set<String> genres;
}
