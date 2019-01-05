package com.github.sankowskiwojciech.bookhunter.service.user.library;

import com.github.sankowskiwojciech.bookhunter.backend.user.library.UserLibraryBackend;
import com.github.sankowskiwojciech.bookhunter.model.user.library.UserLibrary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class UserLibraryServiceImpl implements UserLibraryService {

    private static final int MAX_RECENTLY_VIEWED_BOOKS = 5;

    private final UserLibraryBackend userLibraryBackend;

    @Override
    public UserLibrary findUserLibraryByUserName(String userName) {
        return userLibraryBackend.findUserLibraryByUserName(userName);
    }

    @Override
    public void addBookToUserRecentlyViewedBooks(String userName, String bookId) {
        UserLibrary userLibrary = userLibraryBackend.findUserLibraryByUserName(userName);
        if (userLibrary != null) {
            updateUserLibraryByAddingNewBook(userLibrary, bookId);
        } else {
            userLibrary = createUserLibraryAndAddNewBook(userName, bookId);
        }
        userLibraryBackend.updateUserLibrary(userLibrary);
    }

    private UserLibrary createUserLibraryAndAddNewBook(String userName, String bookId) {
        UserLibrary newUserLibrary = new UserLibrary();
        List<String> recentlyViewedBooksList = Stream.of(bookId).collect(Collectors.toList());
        newUserLibrary.setRecentlyViewedBooks(recentlyViewedBooksList);
        newUserLibrary.setUserName(userName);
        return newUserLibrary;
    }

    private void updateUserLibraryByAddingNewBook(UserLibrary userLibrary, String bookId) {
        List<String> recentlyViewedBooksList = userLibrary.getRecentlyViewedBooks();
        if (!recentlyViewedBooksList.contains(bookId)) {
            if (recentlyViewedBooksList.size() == MAX_RECENTLY_VIEWED_BOOKS) {
                recentlyViewedBooksList.remove(0);
            }
            recentlyViewedBooksList.add(recentlyViewedBooksList.size(), bookId);
        }
    }
}
