package com.github.sankowskiwojciech.bookhunter.backend.book.rating.transformer;

import com.github.sankowskiwojciech.bookhunter.model.book.rating.BookRating;
import com.github.sankowskiwojciech.bookhunter.model.book.rating.db.BookRatingEntity;

import java.util.function.Function;

public class BookRatingToBookRatingEntity implements Function<BookRating, BookRatingEntity> {
    @Override
    public BookRatingEntity apply(BookRating bookRating) {
        return new BookRatingEntity(
                bookRating.getId(),
                bookRating.getRateOne(),
                bookRating.getRateTwo(),
                bookRating.getRateThree(),
                bookRating.getRateFour(),
                bookRating.getRateFive()
        );
    }
}
