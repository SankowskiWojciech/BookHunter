package com.github.sankowskiwojciech.bookhunter.backend.author;

import com.github.sankowskiwojciech.bookhunter.backend.author.transformer.AuthorEntityToAuthor;
import com.github.sankowskiwojciech.bookhunter.backend.repository.AuthorRepository;
import com.github.sankowskiwojciech.bookhunter.model.author.Author;
import com.github.sankowskiwojciech.bookhunter.model.author.db.AuthorEntity;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class AuthorBackendImpl implements AuthorBackend {

    private final AuthorRepository authorRepository;

    @Override
    public Author findAuthorById(Long authorId) {
        Optional<AuthorEntity> authorEntityOptional = authorRepository.findById(authorId);
        if (authorEntityOptional.isPresent()) {
            AuthorEntity authorEntity = authorEntityOptional.get();
            return new AuthorEntityToAuthor().apply(authorEntity);
        }
        return null;
    }
}
