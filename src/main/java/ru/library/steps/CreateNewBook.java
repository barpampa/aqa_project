package ru.library.steps;

import io.qameta.allure.Step;
import org.hamcrest.Matchers;
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
                        .spec(Specifications.postInformationSpecification(postBookSave))
                        .post("books/save")
                        .then().log().body()
                        .assertThat()
                        .spec(Specifications.responseSpecification(201))
                        .extract().response().body().as(BookSave.class);

        assertThat(book.getBookId(), Matchers.notNullValue());
    }
}
