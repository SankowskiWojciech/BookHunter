package com.github.sankowskiwojciech.bookhunter.model.book.rating;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RatingProvider {

    public static List<RatingOption> getRatingOptions() {
        return Stream
                .of(
                        new RatingOption("1", 1),
                        new RatingOption("2", 2),
                        new RatingOption("3", 3),
                        new RatingOption("4", 4),
                        new RatingOption("5", 5)
                )
                .collect(Collectors.toList());
    }
}