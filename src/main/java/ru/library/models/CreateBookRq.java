package ru.library.models;

import lombok.Builder;
import lombok.Getter;
import java.io.Serializable;

@Getter
@Builder
public class CreateBookRq implements Serializable {
    private String bookTitle;
    private AuthorDto author;
}
