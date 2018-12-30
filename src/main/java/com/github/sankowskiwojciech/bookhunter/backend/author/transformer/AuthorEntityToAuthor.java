package com.github.sankowskiwojciech.bookhunter.backend.author.transformer;

import com.github.sankowskiwojciech.bookhunter.model.author.Author;
import com.github.sankowskiwojciech.bookhunter.model.author.db.AuthorEntity;

import java.util.function.Function;

public class AuthorEntityToAuthor implements Function<AuthorEntity, Author> {

    @Override
    public Author apply(AuthorEntity authorEntity) {
        return new Author(
                authorEntity.getId(),
                authorEntity.getName(),
                authorEntity.getSurname(),
                authorEntity.getBirthYear(),
                authorEntity.getDeathYear(),
                authorEntity.getProfilePhoto(),
                authorEntity.getDescription(),
                authorEntity.getGenres()
        );
    }
}
