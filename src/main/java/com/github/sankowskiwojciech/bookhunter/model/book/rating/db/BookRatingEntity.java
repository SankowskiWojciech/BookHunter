package com.github.sankowskiwojciech.bookhunter.model.book.rating.db;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_RATING")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@EqualsAndHashCode(of = "id")
public class BookRatingEntity {

    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 13)
    private String id;

    @Column(name = "RATE_ONE")
    private Integer rateOne;

    @Column(name = "RATE_TWO")
    private Integer rateTwo;

    @Column(name = "RATE_THREE")
    private Integer rateThree;

    @Column(name = "RATE_FOUR")
    private Integer rateFour;

    @Column(name = "RATE_FIVE")
    private Integer rateFive;
}
