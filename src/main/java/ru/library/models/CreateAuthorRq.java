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
package ru.library.models;

import java.io.Serializable;

public class CreateAuthorRq implements Serializable { //Здесь специально без lombok
    private String firstName;
    private String familyName;
    private String secondName;

    public CreateAuthorRq(String firstName, String familyName, String secondName) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}


