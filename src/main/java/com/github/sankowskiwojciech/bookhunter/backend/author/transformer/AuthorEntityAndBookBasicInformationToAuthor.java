package com.github.sankowskiwojciech.bookhunter.backend.author.transformer;

import com.github.sankowskiwojciech.bookhunter.model.author.Author;
import com.github.sankowskiwojciech.bookhunter.model.author.db.AuthorEntity;
import com.github.sankowskiwojciech.bookhunter.model.book.BookBasicInformation;

import java.util.List;
import java.util.function.BiFunction;

public class AuthorEntityAndBookBasicInformationToAuthor implements BiFunction<List<BookBasicInformation>, AuthorEntity, Author> {

    @Override
    public Author apply(List<BookBasicInformation> bookBasicInformationList, AuthorEntity authorEntity) {
        return new Author(
                authorEntity.getId(),
                authorEntity.getName(),
                authorEntity.getSurname(),
                authorEntity.getBirthYear(),
                authorEntity.getDeathYear(),
                authorEntity.getProfilePhoto(),
                authorEntity.getDescription(),
                authorEntity.getCategories(),
                bookBasicInformationList
        );
    }
}
