import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.library.steps.ErrLibraryAuthorBooks;
import ru.library.steps.LibraryAllAuthorBooks;
import ru.library.steps.StatusLibraryAuthorBooks;
import java.util.Random;

public class AllAuthorsBooksGET {

    @BeforeAll
    public static void createAuthor() {
    }

    @BeforeAll
    public static void createBook(){
    }

    @Test
    @DisplayName("Проверяем, что на вызов метода вернулся успешный ответ: 200 ОК")
    @Description("Вызов метода GET /authors/id/books. Позитивный сценарий")
    public void successRequestStatus() {
        StatusLibraryAuthorBooks statusLibraryAuthorBooks = new StatusLibraryAuthorBooks();
        statusLibraryAuthorBooks.getStatusCode("120");
    }

    @Test
    @DisplayName("У автора есть книги. Проверяем валидацию ответа по JSON схеме")
    @Description("Вызов метода GET /authors/id/books. Позитивный сценарий")
    public void successRequestValidate() {
        LibraryAllAuthorBooks libraryAllAuthorBooks = new LibraryAllAuthorBooks();
        libraryAllAuthorBooks.getAuthorBooksWithJsonSchema("120");
    }

    @Test
    @DisplayName("У автора нет книг. Проверяем валидацию ответа по JSON схеме")
    @Description("Вызов метода GET /authors/id/books. Позитивный сценарий")
    public void successRequestNoBooksFromAuthor() {
        LibraryAllAuthorBooks libraryAllAuthorBooks = new LibraryAllAuthorBooks();
        libraryAllAuthorBooks.noBooksFromAuthor("117");
    }

    @Test
    @DisplayName("Проверяем, что автор с указанным id не существует в БД")
    @Description("Вызов метода GET /authors/id/books. Негативный сценарий")
    public void failureRequestNoAuthor() {
        Random random = new Random();
        int status = random.nextInt(1000) + 100;
        ErrLibraryAuthorBooks errLibraryAuthorBooks = new ErrLibraryAuthorBooks();
        errLibraryAuthorBooks.getRequestCheckStatusCode(String.valueOf(status), 409);
        errLibraryAuthorBooks.getRequestCheckNoAuthor(String.valueOf(status));
    }

    @Test
    @DisplayName("Проверяем, что передан некорректный обязательный параметр")
    @Description("Вызов метода GET /authors/id/books. Негативный сценарий")
    public void failureRequestBrokenParameter() {
        ErrLibraryAuthorBooks errLibraryAuthorBooks = new ErrLibraryAuthorBooks();
        errLibraryAuthorBooks.getRequestCheckStatusCode("h", 400);
        errLibraryAuthorBooks.getRequestCheckBrokenId("h");
    }
}
