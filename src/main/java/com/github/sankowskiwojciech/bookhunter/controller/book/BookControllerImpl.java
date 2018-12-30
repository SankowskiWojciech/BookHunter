package com.github.sankowskiwojciech.bookhunter.controller.book;

import com.github.sankowskiwojciech.bookhunter.controller.book.transformer.BookToBookResponse;
import com.github.sankowskiwojciech.bookhunter.model.book.Book;
import com.github.sankowskiwojciech.bookhunter.model.book.BookResponse;
import com.github.sankowskiwojciech.bookhunter.service.book.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/book")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookControllerImpl {

    private final BookService bookService;

    @GetMapping("/{bookId}")
    public BookResponse findBookById(@PathVariable String bookId) {
        Book book = bookService.findBookByBookId(bookId);
        return new BookToBookResponse().apply(book);
    }
}
