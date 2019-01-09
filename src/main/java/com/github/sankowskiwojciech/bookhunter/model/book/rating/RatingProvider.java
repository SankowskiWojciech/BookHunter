package com.github.sankowskiwojciech.bookhunter.model.book.rating;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RatingProvider {

    public static Map<String, Integer> getRatingOptions() {
        Map<String, Integer> ratingOptions = new HashMap<>();
        ratingOptions.put("1", 1);
        ratingOptions.put("2", 2);
        ratingOptions.put("3", 3);
        ratingOptions.put("4", 4);
        ratingOptions.put("5", 5);
        return ratingOptions;
    }
}