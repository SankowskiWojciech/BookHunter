package com.github.sankowskiwojciech.bookhunter.controller.author.transformer;

import com.github.sankowskiwojciech.bookhunter.model.author.Author;
import com.github.sankowskiwojciech.bookhunter.model.author.AuthorResponse;
import com.github.sankowskiwojciech.bookhunter.model.category.Category;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AuthorToAuthorResponse implements Function<Author, AuthorResponse> {

    private static final String IMAGE_DATA_ENCODED_BASE_64_PREFIX = "data:image/jpg;base64,";

    @Override
    public AuthorResponse apply(Author author) {
        return new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getSurname(),
                author.getBirthYear(),
                author.getDeathYear(),
                getCoverImageData(author.getProfilePhoto()),
                author.getDescription(),
                getCategoriesAsString(author.getCategories()),
                author.getBooks()
        );
    }

    private String getCategoriesAsString(Set<Category> categoriesSet) {
        List<String> categoriesList = categoriesSet.stream().map(Category::getCategory).collect(Collectors.toList());
        return String.join(" ", categoriesList);
    }

    private String getCoverImageData(byte[] encodedImage) {
        return encodedImage != null ? IMAGE_DATA_ENCODED_BASE_64_PREFIX + new String(encodedImage, StandardCharsets.UTF_8) : null;
    }
}
