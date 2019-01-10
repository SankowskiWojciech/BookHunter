package com.github.sankowskiwojciech.bookhunter.controller.book.transformer;

import com.github.sankowskiwojciech.bookhunter.model.book.Book;
import com.github.sankowskiwojciech.bookhunter.model.book.BookResponse;
import com.github.sankowskiwojciech.bookhunter.model.book.rating.BookRating;
import com.github.sankowskiwojciech.bookhunter.model.category.Category;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookToBookResponse implements Function<Book, BookResponse> {

    private static final String IMAGE_DATA_ENCODED_BASE_64_PREFIX = "data:image/jpg;base64,";

    @Override
    public BookResponse apply(Book book) {
        Integer numberOfRates = getNumberOfRates(book.getBookRating());
        return new BookResponse(
                book.getIsbn(),
                book.getTitle(),
                book.getOriginalTitle(),
                book.getReleaseYear(),
                getCategoriesAsString(book.getCategories()),
                book.getDescription(),
                getCountryByCountryCode(book.getCountryCode()),
                getCoverImageData(book.getCoverImage()),
                book.getAuthors(),
                getNumberOfRates(book.getBookRating()),
                getAverageRate(book.getBookRating(), numberOfRates)
        );
    }

    private String getCountryByCountryCode(String countryCode) {
        return new Locale("", countryCode).getDisplayCountry();
    }

    private String getCategoriesAsString(Set<Category> categoriesSet) {
        List<String> categoriesList = categoriesSet.stream().map(Category::getCategory).collect(Collectors.toList());
        return String.join(" ", categoriesList);
    }

    private String getCoverImageData(byte[] encodedImage) {
        return encodedImage != null ? IMAGE_DATA_ENCODED_BASE_64_PREFIX + new String(encodedImage, StandardCharsets.UTF_8) : null;
    }

    private Integer getNumberOfRates(BookRating bookRating) {
        if (bookRating != null) {
            return bookRating.getRateOne() +
                    bookRating.getRateTwo() +
                    bookRating.getRateThree() +
                    bookRating.getRateFour() +
                    bookRating.getRateFive();
        }
        return 0;
    }

    private Double getAverageRate(BookRating bookRating, Integer numberOfRates) {
        if (numberOfRates != 0) {
            return (bookRating.getRateOne() * 1. +
                    bookRating.getRateTwo() * 2. +
                    bookRating.getRateThree() * 3. +
                    bookRating.getRateFour() * 4. +
                    bookRating.getRateFive() * 5.) / numberOfRates;
        }
        return 0.0;
    }
}
