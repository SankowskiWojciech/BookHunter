package com.github.sankowskiwojciech.bookhunter.controller.author;

import com.github.sankowskiwojciech.bookhunter.controller.author.transformer.AuthorToAuthorResponse;
import com.github.sankowskiwojciech.bookhunter.model.author.Author;
import com.github.sankowskiwojciech.bookhunter.model.author.AuthorResponse;
import com.github.sankowskiwojciech.bookhunter.service.author.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/author")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorControllerImpl {

    private final AuthorService authorService;

    @GetMapping("/{authorId}")
    public AuthorResponse findAuthorById(@PathVariable Long authorId) {
        Author author = authorService.findAuthorById(authorId);
        return new AuthorToAuthorResponse().apply(author);
    }
}