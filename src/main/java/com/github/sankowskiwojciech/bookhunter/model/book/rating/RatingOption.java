package com.github.sankowskiwojciech.bookhunter.model.book.rating;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RatingOption {
    private String optionName;
    private Integer optionValue;
}
