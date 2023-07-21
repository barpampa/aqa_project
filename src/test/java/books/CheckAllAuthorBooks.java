package books;

import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.library.models.postgresql.response.AllAuthorBooksRs;
import ru.library.steps.LibraryAuthorBooks;
import ru.library.steps.LibraryAuthorBooks.*;

import java.util.List;

import static io.restassured.RestAssured.given;
import static ru.library.steps.LibraryAuthorBooks.checkSumStep;


public class CheckAllAuthorBooks {
    //private final static String URL = "http://localhost:8080/";

    @Test
    @DisplayName("Проверяем, что на вызов метода вернулся успешный ответ: 200 ОК")
    @Description("Вызов метода GET /authors/id/books. Позитивный сценарий")
    public void getAllAuthorBooks() {
        LibraryAuthorBooks libraryAuthorBooks = new LibraryAuthorBooks();
        libraryAuthorBooks.AllAuthorBooks(2L, 200);
        int i = 0; //дебаг
    }

    @Test
    @DisplayName("Проверяем валидацию ответа по JSON схеме")
    @Description("Вызов метода GET /authors/id/books. Позитивный сценарий")
    public void getAllAuthorBooksValidate() {
        LibraryAuthorBooks libraryAuthorBooks = new LibraryAuthorBooks();
        libraryAuthorBooks.getRequestCheckResponseWithJsonSchema(2L);
        int i = 0; //дебаг
    }

    //тестовый тест :)
    @Test
    @DisplayName("simpleTest2")
    @Description("Some detailed test description")
    public void simpleTest2() {
        checkSumStep(3, 2, 5);
        checkSumStep(5, 4, 9);
    }
}
