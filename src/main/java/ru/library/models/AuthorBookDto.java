package ru.library.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorBookDto {
    private long id;
    private String firstName;
    private String secondName;
    private String familyName;

}
