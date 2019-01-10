package com.github.sankowskiwojciech.bookhunter.config;

import com.github.sankowskiwojciech.bookhunter.backend.author.AuthorBackend;
import com.github.sankowskiwojciech.bookhunter.backend.book.BookBackend;
import com.github.sankowskiwojciech.bookhunter.backend.book.rating.BookRatingBackend;
import com.github.sankowskiwojciech.bookhunter.backend.user.authentication.AuthenticationBackend;
import com.github.sankowskiwojciech.bookhunter.backend.user.library.UserLibraryBackend;
import com.github.sankowskiwojciech.bookhunter.backend.user.registration.RegistrationBackend;
import com.github.sankowskiwojciech.bookhunter.service.author.AuthorService;
import com.github.sankowskiwojciech.bookhunter.service.author.AuthorServiceImpl;
import com.github.sankowskiwojciech.bookhunter.service.book.BookService;
import com.github.sankowskiwojciech.bookhunter.service.book.BookServiceImpl;
import com.github.sankowskiwojciech.bookhunter.service.user.authentication.UserDetailsServiceImpl;
import com.github.sankowskiwojciech.bookhunter.service.user.library.UserLibraryService;
import com.github.sankowskiwojciech.bookhunter.service.user.library.UserLibraryServiceImpl;
import com.github.sankowskiwojciech.bookhunter.service.user.registration.RegistrationService;
import com.github.sankowskiwojciech.bookhunter.service.user.registration.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ServiceConfig {

    @Autowired
    private BookBackend bookBackend;

    @Autowired
    private AuthorBackend authorBackend;

    @Autowired
    private RegistrationBackend registrationBackend;

    @Autowired
    private AuthenticationBackend authenticationBackend;

    @Autowired
    private UserLibraryBackend userLibraryBackend;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BookRatingBackend bookRatingBackend;

    @Bean
    public RegistrationService registrationService() {
        return new RegistrationServiceImpl(registrationBackend, passwordEncoder);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(authenticationBackend);
    }

    @Bean
    public AuthorService authorService() {
        return new AuthorServiceImpl(authorBackend);
    }

    @Bean
    public BookService bookService() {
        return new BookServiceImpl(bookBackend, bookRatingBackend);
    }

    @Bean
    public UserLibraryService userLibraryService() {
        return new UserLibraryServiceImpl(userLibraryBackend);
    }
}
