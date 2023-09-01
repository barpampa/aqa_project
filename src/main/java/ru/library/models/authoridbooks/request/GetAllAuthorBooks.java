package ru.library.models.authoridbooks.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAllAuthorBooks {
    private Long id;
}
