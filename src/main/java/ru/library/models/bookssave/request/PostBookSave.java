package ru.library.models.bookssave.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostBookSave{
    public String bookTitle;
    public AuthorDTO author;
}
