package com.github.sankowskiwojciech.bookhunter.model.book.db;

import com.github.sankowskiwojciech.bookhunter.model.genre.Genre;
import com.github.sankowskiwojciech.bookhunter.model.genre.converter.GenresConverter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.InputStream;
import java.util.Set;

@Entity
@Table(name = "BOOK")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@EqualsAndHashCode(of = "isbn")
public class BookEntity {

    @Id
    @Column(name = "ISBN", unique = true, nullable = false, length = 13)
    private String isbn;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "ORIGINAL_TITLE")
    private String originalTitle;

    @Column(name = "RELEASE_YEAR", nullable = false, length = 4)
    private String releaseYear;

    @Column(name = "GENRES", nullable = false)
    @Convert(converter = GenresConverter.class)
    private Set<Genre> genres;

    @Column(name = "DESCRIPTION", length = 5000)
    private String description;

    @Column(name = "COUNTRY_CODE", nullable = false)
    private String countryCode;

    @Lob
    @Column(name = "COVER_IMAGE")
    private InputStream coverImage;
}