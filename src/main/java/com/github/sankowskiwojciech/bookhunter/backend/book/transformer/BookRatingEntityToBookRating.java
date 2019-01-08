package com.github.sankowskiwojciech.bookhunter.backend.book.transformer;

import com.github.sankowskiwojciech.bookhunter.model.book.rating.BookRating;
import com.github.sankowskiwojciech.bookhunter.model.book.rating.db.BookRatingEntity;

import java.util.function.Function;

public class BookRatingEntityToBookRating implements Function<BookRatingEntity, BookRating> {
    @Override
    public BookRating apply(BookRatingEntity bookRatingEntity) {
        if (bookRatingEntity != null) {
            return new BookRating(
                    bookRatingEntity.getId(),
                    bookRatingEntity.getRateOne(),
                    bookRatingEntity.getRateTwo(),
                    bookRatingEntity.getRateThree(),
                    bookRatingEntity.getRateFour(),
                    bookRatingEntity.getRateFive()
            );
        }
        return null;
    }
}
