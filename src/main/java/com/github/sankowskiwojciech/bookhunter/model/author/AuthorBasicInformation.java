package com.github.sankowskiwojciech.bookhunter.model.author;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthorBasicInformation {

    private final Long id;
    private final String name;
    private final String surName;
}
