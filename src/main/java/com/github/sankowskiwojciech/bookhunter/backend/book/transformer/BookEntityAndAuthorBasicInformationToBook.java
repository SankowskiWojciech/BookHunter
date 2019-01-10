package com.github.sankowskiwojciech.bookhunter.backend.book.transformer;

import com.github.sankowskiwojciech.bookhunter.backend.book.rating.transformer.BookRatingEntityToBookRating;
import com.github.sankowskiwojciech.bookhunter.model.author.AuthorBasicInformation;
import com.github.sankowskiwojciech.bookhunter.model.book.Book;
import com.github.sankowskiwojciech.bookhunter.model.book.db.BookEntity;

import java.util.List;
import java.util.function.BiFunction;

public class BookEntityAndAuthorBasicInformationToBook implements BiFunction<List<AuthorBasicInformation>, BookEntity, Book> {
    @Override
    public Book apply(List<AuthorBasicInformation> authorBasicInformationList, BookEntity bookEntity) {
        return new Book(
                bookEntity.getIsbn(),
                bookEntity.getTitle(),
                bookEntity.getOriginalTitle(),
                bookEntity.getReleaseYear(),
                bookEntity.getCategories(),
                bookEntity.getDescription(),
                bookEntity.getCountryCode(),
                bookEntity.getCoverImage(),
                authorBasicInformationList,
                new BookRatingEntityToBookRating().apply(bookEntity.getBookRatingEntity())
        );
    }
}
