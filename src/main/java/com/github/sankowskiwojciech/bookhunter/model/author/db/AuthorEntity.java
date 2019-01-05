package com.github.sankowskiwojciech.bookhunter.model.author.db;

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
@Table(name = "AUTHOR")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@EqualsAndHashCode(of = "id")
public class AuthorEntity {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Column(name = "BIRTH_YEAR")
    private String birthYear;

    @Column(name = "DEATH_YEAR")
    private String deathYear;

    @Lob
    @Column(name = "PROFILE_PHOTO")
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] profilePhoto;

    @Column(name = "DESCRIPTION", length = 5000)
    private String description;

    @Column(name = "CATEGORIES")
    @Convert(converter = CategoriesConverter.class)
    private Set<Category> categories;
}
