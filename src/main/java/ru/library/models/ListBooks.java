package ru.library.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ListBooks {
    private AuthorBookDto authorBookDto;
    private BookDto bookDto;
}
