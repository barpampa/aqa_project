import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.library.steps.AllAuthorBooksXML;

public class AllAuthorBooksPOST {

    @Test
    @DisplayName("У автора есть книги. Проверяем валидацию ответа по XSD схеме")
    @Description("Вызов метода POST /library/authors/books. Позитивный сценарий")
    public void successRequestAllAuthorBooksXML() throws Exception {
        AllAuthorBooksXML allAuthorBooksXML = new AllAuthorBooksXML();
        allAuthorBooksXML.requestAllAuthorBooksXML(135L);
    }

    @Test
    @DisplayName("У автора нет книг. Проверяем валидацию ответа по XSD схеме")
    @Description("Вызов метода POST /library/authors/books. Позитивный сценарий")
    public void successRequestAllAuthorWithoutBooksXML() throws Exception {
        AllAuthorBooksXML allAuthorBooksXML = new AllAuthorBooksXML();
        allAuthorBooksXML.requestAllAuthorWithoutBooksXML(134L);
    }


}
