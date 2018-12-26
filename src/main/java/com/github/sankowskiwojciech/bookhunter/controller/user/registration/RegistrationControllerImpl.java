package com.github.sankowskiwojciech.bookhunter.controller.user.registration;

import com.github.sankowskiwojciech.bookhunter.backend.user.registration.RegistrationBackend;
import com.github.sankowskiwojciech.bookhunter.controller.user.registration.validator.EmailValidator;
import com.github.sankowskiwojciech.bookhunter.controller.user.registration.validator.RegistrationRequestValidator;
import com.github.sankowskiwojciech.bookhunter.controller.user.registration.validator.UserNameValidator;
import com.github.sankowskiwojciech.bookhunter.model.user.registration.UserRegistration;
import com.github.sankowskiwojciech.bookhunter.model.user.registration.UserRegistrationDto;
import com.github.sankowskiwojciech.bookhunter.model.user.registration.UserRegistrationResponse;
import com.github.sankowskiwojciech.bookhunter.service.user.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegistrationControllerImpl {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    public UserRegistrationResponse registerUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        RegistrationRequestValidator.validateRequest(userRegistrationDto);
        EmailValidator.validateEmail(userRegistrationDto.getEmailAddress());
        UserNameValidator.validateUserName(userRegistrationDto.getUserName());
        UserRegistration userRegistration = new UserRegistration(userRegistrationDto.getUserName(),
                userRegistrationDto.getPassword(), userRegistrationDto.getEmailAddress());
        UserRegistration registeredUser = registrationService.registerUser(userRegistration);
        return new UserRegistrationResponse(registeredUser.getUserName(), registeredUser.getEmailAddress());
    }
}
