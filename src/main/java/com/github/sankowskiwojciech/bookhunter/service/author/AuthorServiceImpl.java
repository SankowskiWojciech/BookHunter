package com.github.sankowskiwojciech.bookhunter.service.author;

import com.github.sankowskiwojciech.bookhunter.backend.author.AuthorBackend;
import com.github.sankowskiwojciech.bookhunter.model.author.Author;
import com.github.sankowskiwojciech.bookhunter.model.author.exception.AuthorNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorBackend authorBackend;

    @Override
    public Author findAuthorById(Long authorId) {
        Author author = authorBackend.findAuthorById(authorId);
        if (author == null) {
            throw new AuthorNotFoundException();
        }
        return author;
    }
}
