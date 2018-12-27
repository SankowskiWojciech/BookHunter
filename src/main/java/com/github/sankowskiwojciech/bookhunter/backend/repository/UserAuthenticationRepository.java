package com.github.sankowskiwojciech.bookhunter.backend.repository;

import com.github.sankowskiwojciech.bookhunter.model.user.authentication.UserAuthentication;
import com.github.sankowskiwojciech.bookhunter.model.user.authentication.db.UserAuthenticationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthenticationRepository extends JpaRepository<UserAuthenticationEntity, String> {

    Boolean existsByUserName(String userName);

    Boolean existsByEmailAddress(String email);

    Optional<UserAuthentication> findByUserName(String userName);
}
