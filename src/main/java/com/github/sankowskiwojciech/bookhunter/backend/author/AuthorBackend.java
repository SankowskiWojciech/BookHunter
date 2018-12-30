package com.github.sankowskiwojciech.bookhunter.backend.author;

import com.github.sankowskiwojciech.bookhunter.model.author.Author;

public interface AuthorBackend {
    Author findAuthorById(Long authorId);
}
