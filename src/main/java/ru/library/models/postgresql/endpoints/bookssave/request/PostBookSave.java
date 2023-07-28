package ru.library.models.postgresql.endpoints.bookssave.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostBookSave {
    private String bookTitle;
    private List<AuthorIdDTO> authorIdDTO;
}
