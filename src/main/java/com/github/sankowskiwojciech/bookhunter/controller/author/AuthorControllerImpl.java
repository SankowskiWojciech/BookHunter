package com.github.sankowskiwojciech.bookhunter.controller.author;

import com.github.sankowskiwojciech.bookhunter.controller.author.transformer.AuthorToAuthorResponse;
import com.github.sankowskiwojciech.bookhunter.model.author.Author;
import com.github.sankowskiwojciech.bookhunter.model.author.AuthorResponse;
import com.github.sankowskiwojciech.bookhunter.service.author.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/author")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorControllerImpl {

    private static final String NAME_ATTRIBUTE_NAME = "name";
    private static final String SURNAME_TITLE_ATTRIBUTE_NAME = "surname";
    private static final String BIRTH_YEAR_ATTRIBUTE_NAME = "birthYear";
    private static final String DEATH_YEAR_ATTRIBUTE_NAME = "deathYear";
    private static final String PROFILE_PHOTO_ATTRIBUTE_NAME = "profilePhoto";
    private static final String DESCRIPTION_ATTRIBUTE_NAME = "description";
    private static final String CATEGORIES_ATTRIBUTE_NAME = "categories";
    private static final String BOOKS_ATTRIBUTE_NAME = "books";

    private final AuthorService authorService;

    @GetMapping("/{authorId}")
    public ModelAndView findAuthorById(@PathVariable Long authorId) {

        Author author = authorService.findAuthorById(authorId);

        ModelAndView modelAndView = new ModelAndView("author/author");

        AuthorResponse authorResponse = new AuthorToAuthorResponse().apply(author);

        modelAndView.addObject(NAME_ATTRIBUTE_NAME, authorResponse.getName());
        modelAndView.addObject(SURNAME_TITLE_ATTRIBUTE_NAME, authorResponse.getSurname());
        modelAndView.addObject(BIRTH_YEAR_ATTRIBUTE_NAME, authorResponse.getBirthYear());
        modelAndView.addObject(DEATH_YEAR_ATTRIBUTE_NAME, authorResponse.getDeathYear());
        modelAndView.addObject(PROFILE_PHOTO_ATTRIBUTE_NAME, authorResponse.getProfilePhoto());
        modelAndView.addObject(CATEGORIES_ATTRIBUTE_NAME, authorResponse.getCategories());
        modelAndView.addObject(DESCRIPTION_ATTRIBUTE_NAME, authorResponse.getDescription());
        modelAndView.addObject(BOOKS_ATTRIBUTE_NAME, authorResponse.getBooks());

        return modelAndView;
    }
}