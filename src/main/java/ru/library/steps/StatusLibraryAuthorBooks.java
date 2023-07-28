package ru.library.steps;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import ru.library.steps.specifications.Specifications;

public class StatusLibraryAuthorBooks {

    @Step("Отправляем запрос GET /authors/id/books")
    public void getStatus(Long id){
        String i = RestAssured
                .given().log().all()
                .spec(Specifications.requestSpecification())
                .pathParam("id", id)
                .get("/library/authors/{id}/books")
                .then().log().body()
                .spec(Specifications.responseSpecification()).toString();
        System.out.println(i);
    }
}
