package com.github.sankowskiwojciech.bookhunter.config;

import com.github.sankowskiwojciech.bookhunter.backend.author.AuthorBackend;
import com.github.sankowskiwojciech.bookhunter.backend.author.AuthorBackendImpl;
import com.github.sankowskiwojciech.bookhunter.backend.book.BookBackend;
import com.github.sankowskiwojciech.bookhunter.backend.book.BookBackendImpl;
import com.github.sankowskiwojciech.bookhunter.backend.repository.AuthorRepository;
import com.github.sankowskiwojciech.bookhunter.backend.repository.BookAuthorRelationRepository;
import com.github.sankowskiwojciech.bookhunter.backend.repository.BookRepository;
import com.github.sankowskiwojciech.bookhunter.backend.repository.UserAuthenticationRepository;
import com.github.sankowskiwojciech.bookhunter.backend.repository.UserLibraryRepository;
import com.github.sankowskiwojciech.bookhunter.backend.user.authentication.AuthenticationBackend;
import com.github.sankowskiwojciech.bookhunter.backend.user.authentication.AuthenticationBackendImpl;
import com.github.sankowskiwojciech.bookhunter.backend.user.library.UserLibraryBackend;
import com.github.sankowskiwojciech.bookhunter.backend.user.library.UserLibraryBackendImpl;
import com.github.sankowskiwojciech.bookhunter.backend.user.registration.RegistrationBackend;
import com.github.sankowskiwojciech.bookhunter.backend.user.registration.RegistrationBackendImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackendConfig {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookAuthorRelationRepository bookAuthorRelationRepository;

    @Autowired
    private UserAuthenticationRepository userAuthenticationRepository;

    @Autowired
    private UserLibraryRepository userLibraryRepository;

    @Bean
    public RegistrationBackend registrationBackend() {
        return new RegistrationBackendImpl(userAuthenticationRepository);
    }

    @Bean
    public AuthenticationBackend authenticationBackend() {
        return new AuthenticationBackendImpl(userAuthenticationRepository);
    }

    @Bean
    public AuthorBackend authorBackend() {
        return new AuthorBackendImpl(authorRepository, bookAuthorRelationRepository);
    }

    @Bean
    public BookBackend bookBackend() {
        return new BookBackendImpl(bookRepository, bookAuthorRelationRepository);
    }

    @Bean
    public UserLibraryBackend userLibrary() {
        return new UserLibraryBackendImpl(userLibraryRepository, userAuthenticationRepository);
    }
}
