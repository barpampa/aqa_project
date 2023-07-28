package ru.library.steps;

import io.qameta.allure.Step;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import ru.library.steps.specifications.Specifications;

import static io.restassured.RestAssured.given;

public class ErrLibraryAuthorBooks {

    @Step("Отправляем запрос GET /authors/id/books.Проверяем, что Status code = 409")
    public void getRequestCheckStatus(Long id) { given().log().all()
                .spec(Specifications.requestSpecification())
                .pathParam("id", id)
                .get("/library/authors/{id}/books")
                .then().log().body()
                .spec(Specifications.responseSpecificationErr(409));
    }
    @Step("Отправляем запрос GET /authors/id/books.Проверяем body ошибки")
    public void getRequestCheckNoAuthor(Long id) {
        given().log().all()
                .spec(Specifications.requestSpecification())
                .pathParam("id", id)
                .get("/library/authors/{id}/books")
                .then().log().body()
                .assertThat()
                .body("errorCode", Matchers.is("1004"))
                .body("errorMessage", Matchers.is("Указанный автор не существует в таблице"));
    }
}

