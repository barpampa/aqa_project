package ru.library.steps.specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

    final static String URI = "http://localhost:8080/";
    final static String BASE_PATH = "library";

    public static RequestSpecBuilder commonSpecBuilder() {
        return new RequestSpecBuilder()
                .setBaseUri(URI)
                .setBasePath(BASE_PATH)
                .setContentType(ContentType.JSON);
    }

    public static RequestSpecification getInformationSpecification(String id, String path) {
        return commonSpecBuilder()
                .setBasePath(BASE_PATH + path)
                .addPathParam("id", id)
                .build();
    }

    public static RequestSpecification postInformationSpecification(Object body) {
        return commonSpecBuilder()
                .setBody(body)
                .build();
    }

    public static ResponseSpecification responseSpecification(int statusCode) {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(statusCode)
                .build();
    }
}
