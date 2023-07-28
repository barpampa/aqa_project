package ru.library.steps;

import io.qameta.allure.Step;
import io.restassured.module.jsv.JsonSchemaValidator;
import ru.library.steps.specifications.Specifications;

import static io.restassured.RestAssured.given;

public class LibraryAllAuthorBooks {

    @Step("Отправляем запрос GET /authors/id/books")
    public void getRequestCheckResponseWithJsonSchema(Long id) {
                 given().log().all()
                .spec(Specifications.requestSpecification())
                .pathParam("id", id)
                .get("/library/authors/{id}/books")
                .then().log().body()
                .spec(Specifications.responseSpecification())
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("AllAuthorBooksRs.json"));
    }
}
