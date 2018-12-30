package com.github.sankowskiwojciech.bookhunter.model.genre.converter;

import com.github.sankowskiwojciech.bookhunter.model.genre.Category;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Converter
public class CategoriesConverter implements AttributeConverter<Set<Category>, String> {

    private static final String REGEX_SPLIT = " ";

    @Override
    public String convertToDatabaseColumn(Set<Category> categories) {
        Set<String> categoriesStringSet = categories.stream().map(Category::name).collect(Collectors.toSet());
        return String.join(" ", categoriesStringSet);
    }

    @Override
    public Set<Category> convertToEntityAttribute(String categoriesString) {
        String[] categoriesSetString = categoriesString.trim().split(REGEX_SPLIT);
        return Arrays.stream(categoriesSetString).map(Category::valueOf).collect(Collectors.toSet());
    }
}
