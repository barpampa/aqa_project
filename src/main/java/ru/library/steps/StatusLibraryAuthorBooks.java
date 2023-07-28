package ru.library.steps;

import io.qameta.allure.Step;
import ru.library.steps.specifications.Specifications;

import static io.restassured.RestAssured.given;

public class StatusLibraryAuthorBooks {

    @Step("Отправляем запрос GET /authors/id/books")
    public void getStatusCode(String id) {
                 given().log().all()
                .spec(Specifications.getInformationSpecification(id, "/authors/{id}/books"))
                .get("")
                .then().log().body()
                .spec(Specifications.responseSpecification(200));
    }
}
