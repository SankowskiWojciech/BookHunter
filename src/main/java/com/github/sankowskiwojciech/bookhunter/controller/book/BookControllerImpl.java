package com.github.sankowskiwojciech.bookhunter.controller.book;

import com.github.sankowskiwojciech.bookhunter.controller.book.transformer.BookToBookResponse;
import com.github.sankowskiwojciech.bookhunter.model.book.Book;
import com.github.sankowskiwojciech.bookhunter.model.book.BookResponse;
import com.github.sankowskiwojciech.bookhunter.service.book.BookService;
import com.github.sankowskiwojciech.bookhunter.service.user.library.UserLibraryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/book")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookControllerImpl {

    private static final String COVER_IMAGE_ATTRIBUTE_NAME = "coverImage";
    private static final String TITLE_ATTRIBUTE_NAME = "title";
    private static final String ORIGINAL_TITLE_ATTRIBUTE_NAME = "originalTitle";
    private static final String RELEASE_YEAR_ATTRIBUTE_NAME = "releaseYear";
    private static final String DESCRIPTION_ATTRIBUTE_NAME = "description";
    private static final String COUNTRY_ATTRIBUTE_NAME = "country";
    private static final String CATEGORIES_ATTRIBUTE_NAME = "categories";
    private static final String AUTHORS_ATTRIBUTE_NAME = "authors";
    private static final String BOOKS_ATTRIBUTE_NAME = "books";

    private final BookService bookService;
    private final UserLibraryService userLibraryService;

    @GetMapping("/{bookId}")
    public ModelAndView findBookById(@PathVariable String bookId) {
        Book book = bookService.findBookByBookId(bookId);
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        userLibraryService.addBookToUserRecentlyViewedBooks(userName, book.getIsbn());

        ModelAndView modelAndView = new ModelAndView("book/book");

        BookResponse bookResponse = new BookToBookResponse().apply(book);

        modelAndView.addObject(COVER_IMAGE_ATTRIBUTE_NAME, bookResponse.getCoverImage());
        modelAndView.addObject(TITLE_ATTRIBUTE_NAME, bookResponse.getTitle());
        modelAndView.addObject(ORIGINAL_TITLE_ATTRIBUTE_NAME, bookResponse.getOriginalTitle());
        modelAndView.addObject(RELEASE_YEAR_ATTRIBUTE_NAME, bookResponse.getReleaseYear());
        modelAndView.addObject(DESCRIPTION_ATTRIBUTE_NAME, bookResponse.getDescription());
        modelAndView.addObject(COUNTRY_ATTRIBUTE_NAME, bookResponse.getCountry());
        modelAndView.addObject(CATEGORIES_ATTRIBUTE_NAME, bookResponse.getCategories());
        modelAndView.addObject(AUTHORS_ATTRIBUTE_NAME, bookResponse.getAuthors());

        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView searchBook(@RequestParam String searchValue) {
        List<Book> bookList = bookService.findBookByTitleIgnoreCaseContainingSequence(searchValue);
        BookToBookResponse transformer = new BookToBookResponse();
        List<BookResponse> bookResponseList = bookList.stream().map(transformer).collect(Collectors.toList());
        ModelAndView modelAndView = new ModelAndView("book/search-results");
        modelAndView.addObject(BOOKS_ATTRIBUTE_NAME, bookResponseList);
        return modelAndView;
    }
}
