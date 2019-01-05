package com.github.sankowskiwojciech.bookhunter.backend.user.library;

import com.github.sankowskiwojciech.bookhunter.backend.repository.UserAuthenticationRepository;
import com.github.sankowskiwojciech.bookhunter.backend.repository.UserLibraryRepository;
import com.github.sankowskiwojciech.bookhunter.backend.user.library.transformer.UserLibraryAndUserAuthenticationEntityToUserLibraryEntity;
import com.github.sankowskiwojciech.bookhunter.backend.user.library.transformer.UserLibraryEntityToUserLibrary;
import com.github.sankowskiwojciech.bookhunter.model.user.authentication.db.UserAuthenticationEntity;
import com.github.sankowskiwojciech.bookhunter.model.user.library.UserLibrary;
import com.github.sankowskiwojciech.bookhunter.model.user.library.db.UserLibraryEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserLibraryBackendImpl implements UserLibraryBackend {

    private final UserLibraryRepository userLibraryRepository;
    private final UserAuthenticationRepository userAuthenticationRepository;

    @Override
    public UserLibrary findUserLibraryByUserName(String userName) {
        UserLibraryEntity userLibraryEntity = userLibraryRepository.findByUserAuthenticationEntityUserName(userName);
        return new UserLibraryEntityToUserLibrary().apply(userLibraryEntity);
    }

    @Override
    public void updateUserLibrary(UserLibrary userLibrary) {
        UserAuthenticationEntity userAuthenticationEntity = userAuthenticationRepository.findByUserName(userLibrary.getUserName());
        if (userAuthenticationEntity != null) {
            UserLibraryEntity userLibraryEntity = new UserLibraryAndUserAuthenticationEntityToUserLibraryEntity().apply(userAuthenticationEntity, userLibrary);
            userLibraryRepository.save(userLibraryEntity);
        }
    }
}
