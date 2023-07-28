package ru.library.steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.codehaus.stax2.validation.XMLValidator;
import ru.library.models.authoridbooks.request.GetAllAuthorBooksXML;
import ru.library.steps.specifications.Specifications;
import ru.library.steps.utils.XMLUtil;

import javax.xml.bind.annotation.XmlSchema;

import static io.restassured.RestAssured.*;

public class AllAuthorBooksXML {

    @Step("Отправляем запрос POST /library/authors/books.Проверяем, что автор создан authorId != null")
    public void requestAllAuthorBooksXML(Long authorId) {
        GetAllAuthorBooksXML getBooks = new GetAllAuthorBooksXML(authorId);
        getBooks.setAuthor_id(authorId);
        String booksXML = XMLUtil.toXML();

        given().log().all()
                .spec(Specifications.postInformationSpecification(booksXML))
                .contentType(ContentType.XML)
                .post("/authors/books")
                .then().log().body()
                .assertThat()
                //.spec(Specifications.responseSpecification(200))
                .extract().response().getBody().as(XmlSchema.class);



    }
}
