package com.github.sankowskiwojciech.bookhunter.backend.repository;

import com.github.sankowskiwojciech.bookhunter.model.user.registration.db.UserRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthenticationRepository extends JpaRepository<UserRegistrationEntity, String> {

    Boolean existsByUserName(String userName);

    Boolean existsByEmailAddress(String email);
}
