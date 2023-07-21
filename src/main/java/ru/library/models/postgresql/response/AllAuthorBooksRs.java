package ru.library.models.postgresql.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllAuthorBooksRs {
    private Long id;
    private String bookTitle;
    private List<AuthorDTO> authorDTO;
}
