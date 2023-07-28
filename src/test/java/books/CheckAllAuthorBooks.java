package books;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.library.steps.ErrLibraryAuthorBooks;
import ru.library.steps.LibraryAllAuthorBooks;
import ru.library.steps.StatusLibraryAuthorBooks;
import ru.library.utils.NumbersGenerator;

import static io.restassured.RestAssured.given;

public class CheckAllAuthorBooks {

    @Test
    @DisplayName("Проверяем, что на вызов метода вернулся успешный ответ: 200 ОК")
    @Description("Вызов метода GET /authors/id/books. Позитивный сценарий")
    public void successRequestStatus() {
        StatusLibraryAuthorBooks statusLibraryAuthorBooks = new StatusLibraryAuthorBooks();
        statusLibraryAuthorBooks.getStatus(2L);
        int i = 0; //дебаг
    }

    @Test
    @DisplayName("Проверяем валидацию ответа по JSON схеме")
    @Description("Вызов метода GET /authors/id/books. Позитивный сценарий")
    public void successRequestValidate() {
        LibraryAllAuthorBooks libraryAllAuthorBooks = new LibraryAllAuthorBooks();
        libraryAllAuthorBooks.getRequestCheckResponseWithJsonSchema(2L);
        int i = 0; //дебаг
    }

    @Test
    @DisplayName("Проверяем валидацию ответа(код 1004), что автор с указанным id не существует в БД")
    @Description("Вызов метода GET /authors/id/books. Негативный сценарий")
    public void failureRequestNoAuthor() {
        NumbersGenerator NotValidId = new NumbersGenerator();
        long id = NotValidId.getRandomValue();
        ErrLibraryAuthorBooks errLibraryAuthorBooks = new ErrLibraryAuthorBooks();
        errLibraryAuthorBooks.getRequestCheckStatus(id);
        errLibraryAuthorBooks.getRequestCheckNoAuthor(id);

    }


}
