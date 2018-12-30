package com.github.sankowskiwojciech.bookhunter.model.relation.db;

import com.github.sankowskiwojciech.bookhunter.model.author.db.AuthorEntity;
import com.github.sankowskiwojciech.bookhunter.model.book.db.BookEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_AUTHOR_RELATIONS")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@EqualsAndHashCode(of = "id")
public class BookAuthorRelationEntity {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_ID", nullable = false)
    private BookEntity bookEntity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTHOR_ID", nullable = false)
    private AuthorEntity authorEntity;
}
