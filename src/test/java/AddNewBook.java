import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.library.entity.Book;
import ru.library.steps.CreateNewBook;
import ru.library.steps.fixtures.LibraryDatabaseFixtureSteps;

public class AddNewBook {

    @Test
    @DisplayName("Тест")
    @Description("Позитивный сценарий")
    public void successRequestCreateNewBookDB() {
        LibraryDatabaseFixtureSteps libraryDatabaseFixtureSteps = new LibraryDatabaseFixtureSteps();
        libraryDatabaseFixtureSteps.deleteAllBookStep();
        libraryDatabaseFixtureSteps.insertBookStep("Test1", 5L);
        libraryDatabaseFixtureSteps.insertBookStep("Test2", 5L);
        libraryDatabaseFixtureSteps.countRowsStep(2L);
        libraryDatabaseFixtureSteps.getBookByTitleStep("Test1");
        libraryDatabaseFixtureSteps.deleteBookByIdStep(84L);
        libraryDatabaseFixtureSteps.countRowsStep(1L);
    }

    @Test
    @DisplayName("Добавить новую книгу. Проверяем валидацию ответа")
    @Description("Вызов метода POST /library/books/save. Позитивный сценарий")
    public void successRequestCreateNewBook() {
        CreateNewBook createNewBook = new CreateNewBook();
        createNewBook.postCreateNewBook("asdf", 135L);
    }

    @Test
    @DisplayName("Добавить новую книгу. Автора нет в базе данных")
    @Description("Вызов метода POST /library/books/save. Негативный сценарий")
    public void successRequestCreateNewBookWithoutAuthor() {
        CreateNewBook createNewBook = new CreateNewBook();
        createNewBook.postCreateNewBookWithoutAuthor("asdf", 1L);
    }

    @Test
    @DisplayName("Добавить новую книгу. Не передан обязательный параметр bookTitle")
    @Description("Вызов метода POST /library/books/save. Негативный сценарий")
    public void failureRequestCreateNewBookWithoutParameter() {
        CreateNewBook createNewBook = new CreateNewBook();
        createNewBook.postCreateNewBookWithoutParameter("", 131L);
    }
}
