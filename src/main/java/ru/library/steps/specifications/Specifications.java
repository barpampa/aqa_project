package ru.library.steps.specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

    final static String URI = "http://localhost:8080/";
    final static String BASE_PATH = "library";

    public static RequestSpecBuilder commonSpecBuilderRq() {
        return new RequestSpecBuilder()
                .setBaseUri(URI)
                .setBasePath(BASE_PATH);
    }

    public static RequestSpecification getInformationSpecification(String id, String path) {
        return commonSpecBuilderRq()
                .setBasePath(BASE_PATH + path)
                .setContentType(ContentType.JSON)
                .addPathParam("id", id)
                .build();
    }

    public static RequestSpecification postInformationSpecificationJSON(Object body) {
        return commonSpecBuilderRq()
                .setBody(body)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification postInformationSpecificationXML(Object body) {
        return commonSpecBuilderRq()
                .setBody(body)
                .setContentType(ContentType.XML)
                .build();
    }

    public static ResponseSpecification responseSpecificationJSON(int statusCode) {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(statusCode)
                .build();
    }

    public static ResponseSpecification responseSpecificationXML(int statusCode) {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.XML)
                .expectStatusCode(statusCode)
                .build();
    }
}
