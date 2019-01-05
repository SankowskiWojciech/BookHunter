package com.github.sankowskiwojciech.bookhunter.service.user.library;

import com.github.sankowskiwojciech.bookhunter.model.user.library.UserLibrary;

public interface UserLibraryService {

    void addBookToUserRecentlyViewedBooks(String userName, String bookId);

    UserLibrary findUserLibraryByUserName(String userName);
}
