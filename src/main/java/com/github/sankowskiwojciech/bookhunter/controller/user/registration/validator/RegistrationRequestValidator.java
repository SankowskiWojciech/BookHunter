package com.github.sankowskiwojciech.bookhunter.controller.user.registration.validator;

import com.github.sankowskiwojciech.bookhunter.model.user.registration.UserRegistrationDto;
import com.github.sankowskiwojciech.bookhunter.model.user.registration.exception.registration.InvalidFieldLengthException;
import com.github.sankowskiwojciech.bookhunter.model.user.registration.exception.registration.MissingMandatoryFieldException;
import com.github.sankowskiwojciech.bookhunter.model.user.registration.exception.registration.PasswordMismatchException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegistrationRequestValidator {

    private static final int MAX_USER_NAME_LENGTH = 20;
    private static final int MIN_USER_NAME_LENGTH = 5;

    private static final int MAX_EMAIL_ADDRESS_LENGTH = 30;
    private static final int MIN_EMAIL_ADDRESS_LENGTH = 0;

    private static final int MAX_PASSWORD_LENGTH = 60;
    private static final int MIN_PASSWORD_LENGTH = 5;

    private static final String USER_NAME_FIELD_NAME = "userName";
    private static final String PASSWORD_FIELD_NAME = "password";
    private static final String EMAIL_ADDRESS_FIELD_NAME = "email address";


    public static void validateRequest(UserRegistrationDto userRegistrationDto) {
        validateIfFieldsAreNotNull(userRegistrationDto);
        validateLengthOfUserName(userRegistrationDto.getUserName());
        validateLengthOfPassword(userRegistrationDto.getPassword());
        validateLengthOfEmailAddress(userRegistrationDto.getEmailAddress());
        validateIfPasswordEqualsMatchingPassword(userRegistrationDto.getPassword(), userRegistrationDto.getMatchingPassword());
    }

    private static void validateIfFieldsAreNotNull(UserRegistrationDto userRegistrationDto) {
        if (userRegistrationDto == null || StringUtils.isEmpty(userRegistrationDto.getUserName()) || StringUtils.isEmpty(userRegistrationDto.getPassword()) || StringUtils.isEmpty(userRegistrationDto.getEmailAddress())) {
            throw new MissingMandatoryFieldException();
        }
    }

    private static void validateLengthOfUserName(String userName) {
        if (!isBetween(userName.length(), MIN_USER_NAME_LENGTH, MAX_USER_NAME_LENGTH)) {
            throw new InvalidFieldLengthException(USER_NAME_FIELD_NAME, MIN_USER_NAME_LENGTH, MAX_USER_NAME_LENGTH);
        }
    }

    private static void validateLengthOfPassword(String password) {
        if (!isBetween(password.length(), MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH)) {
            throw new InvalidFieldLengthException(PASSWORD_FIELD_NAME, MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH);
        }
    }

    private static void validateLengthOfEmailAddress(String emailAddress) {
        if (!isBetween(emailAddress.length(), MIN_EMAIL_ADDRESS_LENGTH, MAX_EMAIL_ADDRESS_LENGTH)) {
            throw new InvalidFieldLengthException(EMAIL_ADDRESS_FIELD_NAME, MIN_EMAIL_ADDRESS_LENGTH, MAX_EMAIL_ADDRESS_LENGTH);
        }
    }

    private static void validateIfPasswordEqualsMatchingPassword(String password, String matchingPassword) {
        if (!password.endsWith(matchingPassword)) {
            throw new PasswordMismatchException();
        }
    }

    private static boolean isBetween(int number, int minValue, int maxValue) {
        return number >= minValue && number <= maxValue;
    }
}