package com.github.sankowskiwojciech.bookhunter.service.book;

import com.github.sankowskiwojciech.bookhunter.model.book.Book;

import java.util.List;

public interface BookService {
    Book findBookByBookId(String bookId);

    List<Book> findBooksByBookIds(List<String> bookIdList);

    List<Book> findBookByTitleIgnoreCaseContainingSequence(String searchValue);
}
