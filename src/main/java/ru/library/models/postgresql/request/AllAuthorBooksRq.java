package ru.library.models.postgresql.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllAuthorBooksRq {
    private Long id;
}
