package ru.library.steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class LibraryAuthorBooks {

    @Step("Отправляем запрос GET /authors/{request.id}/books")
    public long getAllAuthorBooksRs(Long id) {
        return given()
                .when()
                .contentType(ContentType.JSON)
                .get("/library/authors/2/books")
                .then().log().all()
                .extract().body().jsonPath().getLong("id");
    }
}
