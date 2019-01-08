package com.github.sankowskiwojciech.bookhunter.model.book.rating;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BookRating {

    private String id;
    private Integer rateOne;
    private Integer rateTwo;
    private Integer rateThree;
    private Integer rateFour;
    private Integer rateFive;
}
