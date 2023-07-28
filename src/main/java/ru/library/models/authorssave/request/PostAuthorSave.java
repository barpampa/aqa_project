package ru.library.models.authorssave.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostAuthorSave {
    private String firstName;
    private String familyName;
    private String secondName;
}


