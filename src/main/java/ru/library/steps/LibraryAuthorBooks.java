package ru.library.steps;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.Assert;

public class LibraryAuthorBooks {

    @Step("Отправляем запрос GET /authors/id/books")
    public void AllAuthorBooks(Long id, int expectedStatus){
        String i = RestAssured
                .given()
                .pathParam("id", id)
                .when()
                .contentType(ContentType.JSON)
                .get("/library/authors/{id}/books")
                .then().log().all()
                .statusCode(expectedStatus)
                .extract().response().asPrettyString();
        System.out.println(i);
    }

    @Step("Отправляем запрос GET /authors/id/books")
    public void getRequestCheckResponseWithJsonSchema(Long id) {
                 RestAssured.given()
                .pathParam("id", id)
                .when()
                .contentType(ContentType.JSON)
                .get("/library/authors/{id}/books")
                .then().log().all()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("AllAuthorBooksRs.json"));
    }

    //тестовый тест :)
    @Step("проверяет соответствие суммы двух слагаемых ожидаемому результату")
    public static void checkSumStep(int num1, int num2, int expectedSum) {
        Assert.assertTrue("Сумма слагаемых не соответствует ожидаемому значению", num1 + num2 == expectedSum);
    }
}
