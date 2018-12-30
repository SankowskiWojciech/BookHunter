package com.github.sankowskiwojciech.bookhunter.controller.author.transformer;

import com.github.sankowskiwojciech.bookhunter.model.author.Author;
import com.github.sankowskiwojciech.bookhunter.model.author.AuthorResponse;
import com.github.sankowskiwojciech.bookhunter.model.genre.Category;

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
                author.getProfilePhoto(),
                author.getDescription(),
                author.getCategories().stream().map(Category::getCategory).collect(Collectors.toSet())
        );
    }
}
