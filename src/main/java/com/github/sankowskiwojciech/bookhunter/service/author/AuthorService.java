package com.github.sankowskiwojciech.bookhunter.service.author;

import com.github.sankowskiwojciech.bookhunter.model.author.Author;

public interface AuthorService {

    Author findAuthorById(Long authorId);
}
