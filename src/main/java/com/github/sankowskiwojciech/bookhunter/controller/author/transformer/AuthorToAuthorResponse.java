package com.github.sankowskiwojciech.bookhunter.controller.author.transformer;

import com.github.sankowskiwojciech.bookhunter.model.author.Author;
import com.github.sankowskiwojciech.bookhunter.model.author.AuthorResponse;
import com.github.sankowskiwojciech.bookhunter.model.genre.Genre;

import java.util.function.Function;
import java.util.stream.Collectors;

public class AuthorToAuthorResponse implements Function<Author, AuthorResponse> {
    @Override
    public AuthorResponse apply(Author author) {
        return new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getSurname(),
                author.getBirthYear(),
                author.getDeathYear(),
                author.getImage(),
                author.getDescription(),
                author.getGenres().stream().map(Genre::getGenre).collect(Collectors.toSet())
        );
    }
}
