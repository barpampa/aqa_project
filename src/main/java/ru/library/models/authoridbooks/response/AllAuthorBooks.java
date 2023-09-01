package ru.library.models.authoridbooks.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

public class AllAuthorBooks {
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAllAuthorBooks {
        private Long id;
        private String bookTitle;
        private AuthorDTO author;
    }
}
