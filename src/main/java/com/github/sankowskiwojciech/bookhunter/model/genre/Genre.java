package com.github.sankowskiwojciech.bookhunter.model.genre;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum Genre {

    ART("Art"),
    BIOGRAPHY("Biography"),
    BUSINESS("Business"),
    COMICS("Comics"),
    COOKBOOKS("Cookbooks"),
    CRIME("Crime"),
    FANTASY("Fantasy"),
    FICTION("Fiction"),
    HISTORY("History"),
    HORROR("Horror"),
    HUMOR("Humor"),
    MUSIC("Music"),
    NONFICTION("Nonfiction"),
    PHILOSOPHY("Philosophy"),
    POETRY("Poetry"),
    PSYCHOLOGY("Psychology"),
    RELIGION("Religion"),
    ROMANCE("Romance"),
    SCIENCE("Science"),
    SCIENCE_FICTION("Science fiction"),
    SPORTS("Sports"),
    THRILLER("Thriller"),
    TRAVEL("Travel");

    private final String genre;
}
