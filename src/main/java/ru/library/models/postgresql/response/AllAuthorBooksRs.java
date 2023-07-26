package ru.library.models.postgresql.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllAuthorBooksRs {
    private Long id;
    private String bookTitle;
    private AuthorDTO authorDTO;

}
