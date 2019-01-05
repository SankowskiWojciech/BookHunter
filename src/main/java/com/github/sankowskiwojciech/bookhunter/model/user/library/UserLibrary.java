package com.github.sankowskiwojciech.bookhunter.model.user.library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserLibrary {
    private Long id;
    private String userName;
    private List<String> recentlyViewedBooks;
}
