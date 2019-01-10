package com.github.sankowskiwojciech.bookhunter.service.book;

import com.github.sankowskiwojciech.bookhunter.model.book.Book;
import com.github.sankowskiwojciech.bookhunter.model.book.rating.RatingOption;

import java.util.List;

public interface BookService {
    Book findBookByBookId(String bookId);

    List<Book> findBooksByBookIds(List<String> bookIdList);

    List<Book> findBookByTitleIgnoreCaseContainingSequence(String searchValue);

    void rateBook(String bookId, RatingOption selectedRate);
}
