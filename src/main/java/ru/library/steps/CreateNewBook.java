package ru.library.steps;

import io.qameta.allure.Step;
import org.hamcrest.Matchers;
import org.hibernate.Session;
import ru.library.models.bookssave.request.AuthorDTO;
import ru.library.models.bookssave.request.PostBookSave;
import ru.library.models.bookssave.response.BookSave;
import ru.library.steps.specifications.Specifications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateNewBook {

    @Step("Отправляем запрос POST /library/books/save.Проверяем, что книга добавлена bookId != null")
    public void postCreateNewBook(String bookTitle, Long id) {
        AuthorDTO authorDTO = new AuthorDTO(id);
        PostBookSave postBookSave = new PostBookSave(bookTitle, authorDTO);
        BookSave book =
                given().log().all()
                        .spec(Specifications.postInformationSpecificationJSON(postBookSave))
                        .post("books/save")
                        .then().log().body()
                        .assertThat()
                        .spec(Specifications.responseSpecificationJSON(201))
                        .extract().response().body().as(BookSave.class);

        assertThat(book.getBookId(), Matchers.notNullValue());
    }

    @Step("Отправляем запрос POST /library/books/save.Проверяем, что книга не добавлена если не передан обязательный параметр")
    public void postCreateNewBookWithoutParameter(String bookTitle, Long id) {
        AuthorDTO authorDTO = new AuthorDTO(id);
        PostBookSave postBookSave = new PostBookSave(bookTitle, authorDTO);
                given().log().all()
                        .spec(Specifications.postInformationSpecificationJSON(postBookSave))
                        .post("books/save")
                        .then().log().body()
                        .assertThat()
                        .spec(Specifications.responseSpecificationJSON(400))
                        .body("errorDetails", Matchers.is("1001"))
                        .body("errorCode", Matchers.is("Валидация не пройдена"));
    }

    @Step("Отправляем запрос POST /library/books/save.Проверяем, что книга не добавлена если автор не создан")
    public void postCreateNewBookWithoutAuthor(String bookTitle, Long id) {
        AuthorDTO authorDTO = new AuthorDTO(id);
        PostBookSave postBookSave = new PostBookSave(bookTitle, authorDTO);
        given().log().all()
                .spec(Specifications.postInformationSpecificationJSON(postBookSave))
                .post("books/save")
                .then().log().body()
                .assertThat()
                .spec(Specifications.responseSpecificationJSON(409))
                .body("errorCode", Matchers.is("1004"))
                .body("errorMessage", Matchers.is("Указанный автор не существует в таблице"));
    }
}
