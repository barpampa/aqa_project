package ru.library.steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import ru.library.models.CreateAuthorRq;
import ru.library.models.CreateAuthorRs;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;


public class AuthorSaveSteps {

    @Step("Запрос POST http://localhost:8080/library/authors/save Получаем ID сохраненного автора")
    public CreateAuthorRs createAuthorRs(CreateAuthorRq request, int expectedStatus) { //метод ответа на запрос -метод-(-запрос-, -ожидаемый статус код-)
        return given() //что было передано в запросе
                .contentType(ContentType.JSON) //формат данных JSON
                .body(request) //body для запроса с методом POST
               .when() //с каким методом и на какой эндпойнт отправляем запрос
                .post("http://localhost:8080/library/authors/save") //адрес запроса
               .then() //как проверяется пришедший ответ
                .statusCode(expectedStatus) //ожидаем верный статус код
                .extract().jsonPath().get("authorId"); //извлекаем из ответа одно поле, используя JsonPath
    }

}
