package ru.library.models.authoridbooks.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllAuthorBooks {
    private Long id;
    private String bookTitle;
    private AuthorDTO authorDTO;

}
