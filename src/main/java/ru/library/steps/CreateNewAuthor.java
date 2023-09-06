package ru.library.steps;

import io.qameta.allure.Step;
import org.hamcrest.Matchers;
import ru.library.models.authorssave.request.PostAuthorSave;
import ru.library.models.authorssave.response.AuthorSave;
import ru.library.steps.specifications.Specifications;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.given;

public class CreateNewAuthor {

    @Step("Отправляем запрос POST /library/authors/save. Проверяем, что автор создан authorId != null")
    public void postCreateNewAuthor(String firstName, String familyName, String secondName) {
        PostAuthorSave postAuthorSave = new PostAuthorSave(firstName, familyName, secondName);
        AuthorSave author =
        given().log().all()
               .spec(Specifications.postInformationSpecificationJSON(postAuthorSave))
               .post("authors/save")
        .then().log().body()
               .assertThat()
               .spec(Specifications.responseSpecificationJSON(201))
               .extract().response().getBody().as(AuthorSave.class);

        assertThat(author.getAuthorId(), Matchers.notNullValue());
    }

    @Step("Отправляем запрос POST /library/authors/save. Проверяем, что автор уже есть в базе данных")
    public void postCreateNewAuthorRepeat(String firstName, String familyName, String secondName) {
        PostAuthorSave postAuthorSave = new PostAuthorSave(firstName, familyName, secondName);
                given().log().all()
                        .spec(Specifications.postInformationSpecificationJSON(postAuthorSave))
                        .post("authors/save")
                        .then().log().body()
                        .assertThat()
                        .spec(Specifications.responseSpecificationJSON(409))
                        .body("errorCode", Matchers.is("1002"))
                        .body("errorMessage", Matchers.is("Указанный автор уже добавлен в базу данных"));
    }

    @Step("Отправляем запрос POST /library/authors/save.Проверяем, что автора нет в базе данных")
    public void postCreateNewAuthorNoParameter(String firstName, String familyName, String secondName) {
        PostAuthorSave postAuthorSave = new PostAuthorSave(firstName, familyName, secondName);
                given().log().all()
                        .spec(Specifications.postInformationSpecificationJSON(postAuthorSave))
                        .post("authors/save")
                .then().log().body()
                        .assertThat()
                        .spec(Specifications.responseSpecificationJSON(400))
                        .body("errorDetails", Matchers.is("1001"))
                        .body("errorCode", Matchers.is("Валидация не пройдена"));
    }
}
