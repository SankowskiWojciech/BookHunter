package com.github.sankowskiwojciech.bookhunter.backend.repository;

import com.github.sankowskiwojciech.bookhunter.model.user.library.db.UserLibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLibraryRepository extends JpaRepository<UserLibraryEntity, Long> {
    UserLibraryEntity findByUserAuthenticationEntityUserName(String userName);
}
