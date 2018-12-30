package com.github.sankowskiwojciech.bookhunter.service.book;

import com.github.sankowskiwojciech.bookhunter.model.book.Book;

public interface BookService {
    Book findBookByBookId(String bookId);
}
