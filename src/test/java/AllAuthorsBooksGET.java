import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.library.steps.AllAuthorBooksJSON;

import java.util.Random;

public class AllAuthorsBooksGET {

    @Test
    @DisplayName("Проверяем, что на вызов метода вернулся успешный ответ: 200 ОК")
    @Description("Вызов метода GET /authors/id/books. Позитивный сценарий")
    public void successRequestStatus() {
        AllAuthorBooksJSON allAuthorBooksJSON = new AllAuthorBooksJSON();
        allAuthorBooksJSON.getStatusCode("135");
    }

    @Test
    @DisplayName("У автора есть книги. Проверяем валидацию ответа по JSON схеме")
    @Description("Вызов метода GET /authors/id/books. Позитивный сценарий")
    public void successRequestValidate() {
        AllAuthorBooksJSON allAuthorBooksJSON = new AllAuthorBooksJSON();
        allAuthorBooksJSON.getAuthorBooksWithJsonSchema("135");
    }

    @Test
    @DisplayName("У автора нет книг. Проверяем валидацию ответа по JSON схеме")
    @Description("Вызов метода GET /authors/id/books. Позитивный сценарий")
    public void successRequestNoBooksFromAuthor() {
        AllAuthorBooksJSON allAuthorBooksJSON = new AllAuthorBooksJSON();
        allAuthorBooksJSON.noBooksFromAuthor("134");
    }

    @Test
    @DisplayName("Проверяем, что автор с указанным id не существует в БД")
    @Description("Вызов метода GET /authors/id/books. Негативный сценарий")
    public void failureRequestNoAuthor() {
        Random random = new Random();
        int value = random.nextInt(1000) + 100;
        AllAuthorBooksJSON errors = new AllAuthorBooksJSON();
        errors.getRequestCheckStatusCode(String.valueOf(value), 409);
        errors.getRequestCheckNoAuthor(String.valueOf(value));
    }

    @Test
    @DisplayName("Проверяем, что передан некорректный обязательный параметр")
    @Description("Вызов метода GET /authors/id/books. Негативный сценарий")
    public void failureRequestBrokenParameter() {
        AllAuthorBooksJSON errors = new AllAuthorBooksJSON();
        errors.getRequestCheckStatusCode("h", 400);
        errors.getRequestCheckBrokenId("h");
    }
}
