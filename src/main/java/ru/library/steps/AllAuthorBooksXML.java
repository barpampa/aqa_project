package ru.library.steps;

import io.qameta.allure.Step;
import org.hamcrest.Matchers;
import ru.library.steps.specifications.Specifications;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static ru.library.steps.utils.XMLUtil.toXML;

public class AllAuthorBooksXML {

    @Step("Отправляем запрос POST /library/authors/books. Проверяем, какие книги есть у автора")
    public void requestAllAuthorBooksXML(Long author_id) throws Exception{
        given().log().all()
                .spec(Specifications.postInformationSpecificationXML(toXML(author_id)))
                .post("/authors/books")
                .then().log().body()
                .assertThat()
                .spec(Specifications.responseSpecificationXML(200))
                .body(matchesXsdInClasspath("authorBooks.xsd"));
    }

    @Step("Отправляем запрос POST /library/authors/books. Проверяем, что у автора нет книг")
    public void requestAllAuthorWithoutBooksXML(Long author_id) throws Exception{
        given().log().all()
                .spec(Specifications.postInformationSpecificationXML(toXML(author_id)))
                .post("/authors/books")
                .then().log().body()
                .assertThat()
                .spec(Specifications.responseSpecificationXML(200))
                .body(matchesXsdInClasspath("authorNoBooks.xsd"));
    }

    @Step("Отправляем запрос POST /library/authors/books. Проверяем, что у автора нет книг")
    public void requestAllAuthorBooksWithoutAuthorXML(Long author_id) throws Exception{
        given().log().all()
                .spec(Specifications.postInformationSpecificationXML(toXML(author_id)))
                .post("/authors/books")
                .then().log().body()
                .assertThat()
                .spec(Specifications.responseSpecificationXML(200))
                .body("errorCode", Matchers.is("1004"))
                .body("errorMessage", Matchers.is("Указанный автор не существует в таблице"));
    }


}
