/*
Сохранение нового автора.

POST	/authors/save

Входящие параметры:
Параметр	Формат	Тип параметра	Пример
firstName	String	body	Лев
familyName	String	body	Толстой
secondName	String	body	Николаевич
content-type	String	header	application/json

Исходящие параметры:
Позитивный сценарий:
Параметр	Формат	Тип параметра	Пример
authorId	long	body	653

Негативный сценарий:
Параметр	Формат	Тип параметра	Пример
errorCode	number	body	1001
errorMessage	String	body	Не передано имя автора

 */
package ru.library.models.postgresql.endpoints.authorssave.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostAuthorSave {
    private String firstName;
    private String familyName;
    private String secondName;

}


