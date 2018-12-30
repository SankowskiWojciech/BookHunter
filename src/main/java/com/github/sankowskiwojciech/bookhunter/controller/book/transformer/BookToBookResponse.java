package com.github.sankowskiwojciech.bookhunter.controller.book.transformer;

import com.github.sankowskiwojciech.bookhunter.model.book.Book;
import com.github.sankowskiwojciech.bookhunter.model.book.BookResponse;
import com.github.sankowskiwojciech.bookhunter.model.genre.Genre;

import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookToBookResponse implements Function<Book, BookResponse> {
    @Override
    public BookResponse apply(Book book) {
        return new BookResponse(
                book.getIsbn(),
                book.getTitle(),
                book.getOriginalTitle(),
                book.getReleaseYear(),
                book.getGenres().stream().map(Genre::getGenre).collect(Collectors.toSet()),
                book.getDescription(),
                getCountryByCountryCode(book.getCountryCode()),
                book.getCoverImage(),
                book.getAuthors()
        );
    }

    private String getCountryByCountryCode(String countryCode) {
        return new Locale("", countryCode).getDisplayCountry();
    }
}
