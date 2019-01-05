package com.github.sankowskiwojciech.bookhunter.backend.user.library.transformer;

import com.github.sankowskiwojciech.bookhunter.model.user.library.UserLibrary;
import com.github.sankowskiwojciech.bookhunter.model.user.library.db.UserLibraryEntity;

import java.util.function.Function;

public class UserLibraryEntityToUserLibrary implements Function<UserLibraryEntity, UserLibrary> {

    @Override
    public UserLibrary apply(UserLibraryEntity userLibraryEntity) {
        if (userLibraryEntity != null) {
            return new UserLibrary(
                    userLibraryEntity.getId(),
                    userLibraryEntity.getUserAuthenticationEntity().getUserName(),
                    userLibraryEntity.getRecentlyViewedBooks()
            );
        }
        return null;
    }
}
