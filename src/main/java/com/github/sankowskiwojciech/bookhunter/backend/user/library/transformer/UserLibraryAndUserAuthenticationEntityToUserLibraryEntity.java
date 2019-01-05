package com.github.sankowskiwojciech.bookhunter.backend.user.library.transformer;

import com.github.sankowskiwojciech.bookhunter.model.user.authentication.db.UserAuthenticationEntity;
import com.github.sankowskiwojciech.bookhunter.model.user.library.UserLibrary;
import com.github.sankowskiwojciech.bookhunter.model.user.library.db.UserLibraryEntity;

import java.util.function.BiFunction;

public class UserLibraryAndUserAuthenticationEntityToUserLibraryEntity implements BiFunction<UserAuthenticationEntity, UserLibrary, UserLibraryEntity> {

    @Override
    public UserLibraryEntity apply(UserAuthenticationEntity userAuthenticationEntity, UserLibrary userLibrary) {
        return new UserLibraryEntity(
                userLibrary.getId(),
                userAuthenticationEntity,
                userLibrary.getRecentlyViewedBooks()
        );
    }
}
