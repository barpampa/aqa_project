package ru.library.steps;

import io.qameta.allure.Step;
import io.restassured.module.jsv.JsonSchemaValidator;
import ru.library.steps.specifications.Specifications;
import static io.restassured.RestAssured.given;

public class LibraryAllAuthorBooks {

    @Step("Отправляем запрос GET /authors/id/books")
    public void getAuthorBooksWithJsonSchema(String id) {
                 given().log().all()
                .spec(Specifications.getInformationSpecification(id, "/authors/{id}/books"))
                .get()
                .then().log().body()
                .spec(Specifications.responseSpecification(200))
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("authorBooksRs.json"));
    }

    @Step("Отправляем запрос GET /authors/id/books")
    public void noBooksFromAuthor(String id) {
        given().log().all()
                .spec(Specifications.getInformationSpecification(id, "/authors/{id}/books"))
                .get()
                .then().log().body()
                .spec(Specifications.responseSpecification(200))
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("authorNoBooks.json"));
    }
}
