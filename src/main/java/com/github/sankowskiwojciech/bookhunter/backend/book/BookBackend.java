package com.github.sankowskiwojciech.bookhunter.backend.book;

import com.github.sankowskiwojciech.bookhunter.model.book.Book;

public interface BookBackend {

    Book findBookById(String bookId);
}
