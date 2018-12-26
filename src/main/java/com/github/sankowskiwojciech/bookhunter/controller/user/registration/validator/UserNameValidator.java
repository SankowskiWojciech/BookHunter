package com.github.sankowskiwojciech.bookhunter.controller.user.registration.validator;

import com.github.sankowskiwojciech.bookhunter.model.user.registration.exception.registration.InvalidUserNameFormatException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserNameValidator {
    public static void validateUserName(final String userName) {
        if (!StringUtils.isAlphanumeric(userName)) {
            throw new InvalidUserNameFormatException();
        }
    }
}
