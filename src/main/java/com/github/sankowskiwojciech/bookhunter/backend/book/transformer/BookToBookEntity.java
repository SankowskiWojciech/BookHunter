package com.github.sankowskiwojciech.bookhunter.backend.book.transformer;

import com.github.sankowskiwojciech.bookhunter.backend.book.rating.transformer.BookRatingToBookRatingEntity;
import com.github.sankowskiwojciech.bookhunter.model.book.Book;
import com.github.sankowskiwojciech.bookhunter.model.book.db.BookEntity;

import java.util.function.Function;

public class BookToBookEntity implements Function<Book, BookEntity> {
    @Override
    public BookEntity apply(Book book) {
        return new BookEntity(
                book.getIsbn(),
                book.getTitle(),
                book.getOriginalTitle(),
                book.getReleaseYear(),
                book.getCategories(),
                book.getDescription(),
                book.getCountryCode(),
                book.getCoverImage(),
                new BookRatingToBookRatingEntity().apply(book.getBookRating())
        );
    }
}
