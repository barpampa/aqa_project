package ru.library.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetAllAuthorBooksRq {
    private String id;
}
