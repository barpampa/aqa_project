import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.library.steps.CreateNewBook;

public class AddNewBook {

    @Test
    @DisplayName("Добавить новую книгу. Проверяем валидацию ответа")
    @Description("Вызов метода POST /library/books/save. Позитивный сценарий")
    public void successRequestCreateNewBook() {
        CreateNewBook createNewBook = new CreateNewBook();
        createNewBook.postCreateNewBook("asdf", 120L);
    }
}
