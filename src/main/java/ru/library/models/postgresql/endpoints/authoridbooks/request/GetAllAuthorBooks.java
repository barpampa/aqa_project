package ru.library.models.postgresql.endpoints.authoridbooks.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAllAuthorBooks {
    private Long id;
}
