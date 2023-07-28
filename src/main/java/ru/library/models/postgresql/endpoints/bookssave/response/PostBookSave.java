package ru.library.models.postgresql.endpoints.bookssave.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostBookSave {
    private Long bookId;
}
