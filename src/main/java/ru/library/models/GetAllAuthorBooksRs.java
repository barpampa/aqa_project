/*
[
   {
       "id": 1,
       "bookTitle": "Детство",
       "author": {
           "id": 2,
           "firstName": "Лев",
           "secondName": "Толстой"
       }
   },
   {
       "id": 2,
       "bookTitle": "Юность",
       "author": {
           "id": 2,
           "firstName": "Лев",
           "secondName": "Толстой"
       }
   }
]

 */
package ru.library.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import ru.library.entity.Book;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAllAuthorBooksRs {
    List<ListBooks> listBooks;

}
