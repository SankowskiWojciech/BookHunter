package com.github.sankowskiwojciech.bookhunter.service.book;

import com.github.sankowskiwojciech.bookhunter.backend.book.BookBackend;
import com.github.sankowskiwojciech.bookhunter.model.book.Book;
import com.github.sankowskiwojciech.bookhunter.model.book.excetion.BookNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookBackend bookBackend;

    @Override
    public Book findBookByBookId(String bookId) {
        Book book = bookBackend.findBookById(bookId);
        if (book == null) {
            throw new BookNotFoundException();
        }
        return book;
    }
}
