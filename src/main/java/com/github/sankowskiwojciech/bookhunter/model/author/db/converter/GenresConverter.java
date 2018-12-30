package com.github.sankowskiwojciech.bookhunter.model.author.db.converter;

import com.github.sankowskiwojciech.bookhunter.model.genre.Genre;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Converter
public class GenresConverter implements AttributeConverter<Set<Genre>, String> {

    @Override
    public String convertToDatabaseColumn(Set<Genre> genres) {
        Set<String> genresStringSet = genres.stream().map(Genre::name).collect(Collectors.toSet());
        return String.join(" ", genresStringSet);
    }

    @Override
    public Set<Genre> convertToEntityAttribute(String genresString) {
        String[] genresSetString = genresString.trim().split(" ");
        return Arrays.stream(genresSetString).map(Genre::valueOf).collect(Collectors.toSet());
    }
}
