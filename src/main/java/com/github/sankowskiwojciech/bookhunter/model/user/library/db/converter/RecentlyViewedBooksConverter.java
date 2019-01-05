package com.github.sankowskiwojciech.bookhunter.model.user.library.db.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class RecentlyViewedBooksConverter implements AttributeConverter<List<String>, String> {

    private static final String REGEX = " ";

    @Override
    public String convertToDatabaseColumn(List<String> recentlyViewedBooksList) {
        return String.join(REGEX, recentlyViewedBooksList);
    }

    @Override
    public List<String> convertToEntityAttribute(String recentlyViewedBooksString) {
        String[] recentlyViewedBooks = recentlyViewedBooksString.trim().split(REGEX);
        return Arrays.stream(recentlyViewedBooks).collect(Collectors.toList());
    }
}
