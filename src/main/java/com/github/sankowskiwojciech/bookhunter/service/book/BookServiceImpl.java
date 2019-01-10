package com.github.sankowskiwojciech.bookhunter.service.book;

import com.github.sankowskiwojciech.bookhunter.backend.book.BookBackend;
import com.github.sankowskiwojciech.bookhunter.backend.book.rating.BookRatingBackend;
import com.github.sankowskiwojciech.bookhunter.model.book.Book;
import com.github.sankowskiwojciech.bookhunter.model.book.excetion.BookNotFoundException;
import com.github.sankowskiwojciech.bookhunter.model.book.rating.BookRating;
import com.github.sankowskiwojciech.bookhunter.model.book.rating.RatingOption;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookBackend bookBackend;
    private final BookRatingBackend bookRatingBackend;

    @Override
    public Book findBookByBookId(String bookId) {
        Book book = bookBackend.findBookById(bookId);
        if (book == null) {
            throw new BookNotFoundException();
        }
        return book;
    }

    @Override
    public List<Book> findBooksByBookIds(List<String> bookIdList) {
        return bookIdList.stream().map(this::findBookByBookId).collect(Collectors.toList());
    }

    @Override
    public List<Book> findBookByTitleIgnoreCaseContainingSequence(String searchValue) {
        if (searchValue == null || searchValue.trim().isEmpty()) {
            return Collections.emptyList();
        }
        return bookBackend.findByTitleIgnoreCaseContainingSequence(searchValue.trim());
    }

    @Override
    public void rateBook(String bookId, RatingOption selectedRate) {
        Book book = bookBackend.findBookById(bookId);
        BookRating bookRating = book.getBookRating();
        if (bookRating == null) {
            bookRating = new BookRating(bookId, 0, 0, 0, 0, 0);
        }
        prepareBookRating(bookRating, selectedRate);
        book.setBookRating(bookRating);
        bookRatingBackend.saveBookRate(bookRating);
        bookBackend.updateBookData(book);
    }

    private void prepareBookRating(BookRating bookRating, RatingOption selectedRate) {
        switch (selectedRate.getOptionValue()) {
            case 1:
                bookRating.setRateOne(bookRating.getRateOne() + 1);
                break;
            case 2:
                bookRating.setRateTwo(bookRating.getRateTwo() + 1);
                break;
            case 3:
                bookRating.setRateThree(bookRating.getRateTwo() + 1);
                break;
            case 4:
                bookRating.setRateFour(bookRating.getRateFour() + 1);
                break;
            default:
                bookRating.setRateFive(bookRating.getRateFive() + 1);
                break;
        }
    }
}
