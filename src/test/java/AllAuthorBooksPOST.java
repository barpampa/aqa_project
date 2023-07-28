import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.library.steps.AllAuthorBooksXML;

public class AllAuthorBooksPOST {

    @Test
    @DisplayName("1")
    @Description("Вызов метода . Позитивный сценарий")
    public void successRequestAllAuthorBooksXML() {
        AllAuthorBooksXML allAuthorBooksXML = new AllAuthorBooksXML();
        allAuthorBooksXML.requestAllAuthorBooksXML(120L);
    }
}
