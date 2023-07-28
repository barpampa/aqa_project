package ru.library.models.postgresql.endpoints.bookssave.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorIdDTO {
    private Long id;
}
