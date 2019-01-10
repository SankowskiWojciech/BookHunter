package com.github.sankowskiwojciech.bookhunter.backend.book.rating;

import com.github.sankowskiwojciech.bookhunter.model.book.rating.BookRating;

public interface BookRatingBackend {

    void saveBookRate(BookRating bookRating);
}
