package ru.library.steps;

import io.qameta.allure.Step;
import org.hamcrest.Matchers;
import ru.library.steps.specifications.Specifications;

import static io.restassured.RestAssured.given;

public class ErrLibraryAuthorBooks {

    @Step("Отправляем запрос GET /authors/id/books.Проверяем, что Status code = 409")

    public void getRequestCheckStatusCode(String id, int status) {
        given().log().all()
                .spec(Specifications.getInformationSpecification(id, "/authors/{id}/books"))
                .get("")
                .then().log().body()
                .spec(Specifications.responseSpecification(status));
    }

    @Step("Отправляем запрос GET /authors/id/books.Проверяем body ошибки")
    public void getRequestCheckNoAuthor(String id) {
        given().log().all()
                .spec(Specifications.getInformationSpecification(id, "/authors/{id}/books"))
                .pathParam("id", id)
                .get("/library/authors/{id}/books")
                .then().log().body()
                .assertThat()
                .body("errorCode", Matchers.is("1004"))
                .body("errorMessage", Matchers.is("Указанный автор не существует в таблице"));
    }

    @Step("Отправляем запрос GET /authors/id/books.Проверяем body ошибки")
    public void getRequestCheckBrokenId(String id) {
        given().log().all()
                .spec(Specifications.getInformationSpecification(id, "/authors/{id}/books"))
                .get("")
                .then().log().body()
                .assertThat()
                .body("errorCode", Matchers.is("1001"))
                .body("errorMessage", Matchers.is("Некорректный обязательный параметр"));
    }
}


