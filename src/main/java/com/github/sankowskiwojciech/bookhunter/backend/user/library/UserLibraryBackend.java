package com.github.sankowskiwojciech.bookhunter.backend.user.library;

import com.github.sankowskiwojciech.bookhunter.model.user.library.UserLibrary;

public interface UserLibraryBackend {

    UserLibrary findUserLibraryByUserName(String userName);

    void updateUserLibrary(UserLibrary userLibrary);
}
