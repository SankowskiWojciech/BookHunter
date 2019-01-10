package com.github.sankowskiwojciech.bookhunter.backend.book;

import com.github.sankowskiwojciech.bookhunter.model.book.Book;

import java.util.List;

public interface BookBackend {

    Book findBookById(String bookId);

    List<Book> findByTitleIgnoreCaseContainingSequence(String searchValue);

    void updateBookData(Book book);
}
