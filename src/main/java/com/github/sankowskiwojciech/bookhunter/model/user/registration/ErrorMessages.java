package com.github.sankowskiwojciech.bookhunter.model.user.registration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorMessages {

    public static final String INVALID_EMAIL_ADDRESS_FORMAT = "Email address format is invalid";
    public static final String INVALID_USER_NAME_FORMAT = "User name format is invalid";
    public static final String MISSING_MANDATORY_FIELD = "Missing mandatory field";
    public static final String INVALID_LENGTH = "Length of %s field must be between %d and %d characters";
    public static final String USER_ALREADY_EXISTS = "User with given %s already exists";
    public static final String PASSWORD_MISMATCH = "Passwords are different";
}
