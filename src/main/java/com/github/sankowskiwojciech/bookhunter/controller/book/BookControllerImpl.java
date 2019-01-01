package com.github.sankowskiwojciech.bookhunter.controller.book;

import com.github.sankowskiwojciech.bookhunter.controller.book.transformer.BookToBookResponse;
import com.github.sankowskiwojciech.bookhunter.model.book.Book;
import com.github.sankowskiwojciech.bookhunter.model.book.BookResponse;
import com.github.sankowskiwojciech.bookhunter.service.book.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/book")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookControllerImpl {

    private final BookService bookService;

    @GetMapping("/{bookId}")
    public ModelAndView findBookById(@PathVariable String bookId) {
        Book book = bookService.findBookByBookId(bookId);

        ModelAndView modelAndView = new ModelAndView("book/book");

        BookResponse bookResponse = new BookToBookResponse().apply(book);

        modelAndView.addObject("title", bookResponse.getTitle());
        modelAndView.addObject("releaseYear", bookResponse.getReleaseYear());
        modelAndView.addObject("description", bookResponse.getDescription());
        modelAndView.addObject("country", bookResponse.getCountry());
        modelAndView.addObject("categories", bookResponse.getCategories());
        modelAndView.addObject("authors", bookResponse.getAuthors());

        return modelAndView;
    }
}
