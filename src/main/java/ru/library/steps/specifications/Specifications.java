package ru.library.steps.specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public class Specifications {
    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080/")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecification() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static ResponseSpecification responseSpecificationErr(int statusCode) {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(statusCode)
                .build();
    }
}
