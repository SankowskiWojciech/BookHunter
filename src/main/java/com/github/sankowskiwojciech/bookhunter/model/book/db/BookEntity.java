package com.github.sankowskiwojciech.bookhunter.model.book.db;

import com.github.sankowskiwojciech.bookhunter.model.category.Category;
import com.github.sankowskiwojciech.bookhunter.model.category.converter.CategoriesConverter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
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

    @Column(name = "CATEGORIES", nullable = false)
    @Convert(converter = CategoriesConverter.class)
    private Set<Category> categories;

    @Column(name = "DESCRIPTION", length = 5000)
    private String description;

    @Column(name = "COUNTRY_CODE", nullable = false)
    private String countryCode;

    @Lob
    @Column(name = "COVER_IMAGE")
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] coverImage;
}
