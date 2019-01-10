package com.github.sankowskiwojciech.bookhunter.backend.book.rating;

import com.github.sankowskiwojciech.bookhunter.backend.book.rating.transformer.BookRatingToBookRatingEntity;
import com.github.sankowskiwojciech.bookhunter.backend.repository.BookRatingRepository;
import com.github.sankowskiwojciech.bookhunter.model.book.rating.BookRating;
import com.github.sankowskiwojciech.bookhunter.model.book.rating.db.BookRatingEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookRatingBackendImpl implements BookRatingBackend {

    private final BookRatingRepository bookRatingRepository;

    @Override
    public void saveBookRate(BookRating bookRating) {
        BookRatingEntity bookRatingEntity = new BookRatingToBookRatingEntity().apply(bookRating);
        bookRatingRepository.save(bookRatingEntity);
    }
}
