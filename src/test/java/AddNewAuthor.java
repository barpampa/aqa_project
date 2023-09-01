import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.library.steps.CreateNewAuthor;

public class AddNewAuthor {

    @Test
    @DisplayName("Создать нового автора. Проверяем валидацию ответа")
    @Description("Вызов метода POST /library/authors/save. Позитивный сценарий")
    public void successRequestCreateNewAuthor() {
        CreateNewAuthor createNewAuthor = new CreateNewAuthor();
        createNewAuthor.postCreateNewAuthor("Петров1","Иван","Иванович");
    }

    @Test
    @DisplayName("Создать нового автора. Указанный автор уже добавлен в базу данных")
    @Description("Вызов метода POST /library/authors/save. Негативный сценарий")
    public void failureRequestCreateNewAuthorRepeat() {
        CreateNewAuthor createNewAuthor = new CreateNewAuthor();
        createNewAuthor.postCreateNewAuthor("Петров1","Иван","Иванович");
    }

    enum Author {
        Anna, Smith, Maria
    }

    @Test
    @DisplayName("Создать нового автора.Не передан обязательный параметр secondName")
    @Description("Вызов метода POST /library/authors/save. Негативный сценарий")
    public void failureRequestCreateNewAuthorWithNoSecondName() {
        CreateNewAuthor createNewAuthor = new CreateNewAuthor();
        createNewAuthor.postCreateNewAuthorWithNoParameter(Author.Anna.toString(), Author.Smith.toString(), " ");
    }

    @Test
    @DisplayName("Создать нового автора.Не передан обязательный параметр familyName")
    @Description("Вызов метода POST /library/authors/save. Негативный сценарий")
    public void failureRequestCreateNewAuthorWithNoFamilyName() {
        CreateNewAuthor createNewAuthor = new CreateNewAuthor();
        createNewAuthor.postCreateNewAuthorWithNoParameter(Author.Anna.toString(), " ", Author.Maria.toString());
    }

    @Test
    @DisplayName("Создать нового автора.Не передан обязательный параметр firstName")
    @Description("Вызов метода POST /library/authors/save. Негативный сценарий")
    public void failureRequestCreateNewAuthorWithNoFirstName() {
        CreateNewAuthor createNewAuthor = new CreateNewAuthor();
        createNewAuthor.postCreateNewAuthorWithNoParameter(" ", Author.Smith.toString(), Author.Maria.toString());
    }


}
