package com.github.sankowskiwojciech.bookhunter.controller.home;

import com.github.sankowskiwojciech.bookhunter.controller.book.transformer.BookToBookResponse;
import com.github.sankowskiwojciech.bookhunter.model.book.Book;
import com.github.sankowskiwojciech.bookhunter.model.book.BookResponse;
import com.github.sankowskiwojciech.bookhunter.model.user.library.UserLibrary;
import com.github.sankowskiwojciech.bookhunter.service.book.BookService;
import com.github.sankowskiwojciech.bookhunter.service.user.library.UserLibraryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HomeControllerImpl {

    private final UserLibraryService userLibraryService;
    private final BookService bookService;

    private static final String RECENTLY_VIEWED_BOOKS_ATTRIBUTE_NAME = "recentlyViewedBooks";

    @GetMapping
    public ModelAndView showHomePage() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        ModelAndView modelAndView = new ModelAndView("home/home");

        loadRecentlyViewedBooks(modelAndView, userName);

        return modelAndView;
    }

    private void loadRecentlyViewedBooks(ModelAndView modelAndView, String userName) {
        UserLibrary userLibrary = userLibraryService.findUserLibraryByUserName(userName);
        if (userLibrary != null) {
            List<String> booksIds = userLibrary.getRecentlyViewedBooks();
            List<Book> books = bookService.findBooksByBookIds(booksIds);
            BookToBookResponse transformer = new BookToBookResponse();
            List<BookResponse> bookResponseList = books.stream().map(transformer).collect(Collectors.toList());
            modelAndView.addObject(RECENTLY_VIEWED_BOOKS_ATTRIBUTE_NAME, bookResponseList);
        }
    }
}