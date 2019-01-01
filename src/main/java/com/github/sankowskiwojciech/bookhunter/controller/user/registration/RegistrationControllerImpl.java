package com.github.sankowskiwojciech.bookhunter.controller.user.registration;

import com.github.sankowskiwojciech.bookhunter.controller.user.registration.validator.EmailValidator;
import com.github.sankowskiwojciech.bookhunter.controller.user.registration.validator.RegistrationRequestValidator;
import com.github.sankowskiwojciech.bookhunter.controller.user.registration.validator.UserNameValidator;
import com.github.sankowskiwojciech.bookhunter.model.user.authentication.UserAuthentication;
import com.github.sankowskiwojciech.bookhunter.model.user.registration.UserRegistrationDto;
import com.github.sankowskiwojciech.bookhunter.service.user.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegistrationControllerImpl {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute UserRegistrationDto userRegistrationDto) {
        try {
            RegistrationRequestValidator.validateRequest(userRegistrationDto);
            EmailValidator.validateEmail(userRegistrationDto.getEmailAddress());
            UserNameValidator.validateUserName(userRegistrationDto.getUserName());
            UserAuthentication userAuthentication = new UserAuthentication(userRegistrationDto.getUserName(),
                    userRegistrationDto.getPassword(), userRegistrationDto.getEmailAddress());
            registrationService.registerUser(userAuthentication);
        } catch (RuntimeException e) {
            ModelAndView modelAndView = new ModelAndView("register/register");
            modelAndView.addObject("error", e.getMessage());
            return modelAndView;
        }
        return new ModelAndView("register/registration-successful");
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register/register";
    }
}
