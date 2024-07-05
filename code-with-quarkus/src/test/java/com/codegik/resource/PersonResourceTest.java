package com.codegik.resource;

import com.codegik.domain.Person;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class PersonResourceTest {

    @Test
    void getAllShouldSuccess() {
        Person[] person = given()
                .when().get("/person").then()
                .statusCode(200)
                .extract().as(Person[].class);

        assertEquals("Inacio Klassmann", person[0].getName());
        assertEquals(23, person[0].getAge());
    }


    @Test
    void persistShouldSuccess() {
        String request = "{\"name\": \"John Duo\", \"age\": 56}";
        Person person = given()
                .body(request).contentType(ContentType.JSON)
                .when().post("/person")
                .then()
                .statusCode(200)
                .extract().as(Person.class);

        assertEquals("John Duo", person.getName());
        assertEquals(56, person.getAge());
    }


    @Test
    void getByIdShouldSuccess() {
        String request = "{\"name\": \"John Duo\", \"age\": 56}";
        Person person = given()
                .body(request).contentType(ContentType.JSON)
                .when().post("/person")
                .then()
                .statusCode(200)
                .extract().as(Person.class);

        given()
                .when().get("/person/{id}", person.getId())
                .then()
                .statusCode(200);
    }


    @Test
    void deleteByIdShouldSuccess() {
        String request = "{\"name\": \"John Duo\", \"age\": 56}";
        Person person = given()
                .body(request).contentType(ContentType.JSON)
                .when().post("/person")
                .then()
                .statusCode(200)
                .extract().as(Person.class);

        given()
                .when().delete("/person/{id}", person.getId())
                .then()
                .statusCode(200)
                .extract().as(Person.class);
    }


    @Test
    void incorrectUrlShouldFail() {
        given()
                .when().get("/persons")
                .then()
                .statusCode(404);
    }


    @Test
    void getByIdShouldFail() {
        given()
                .when().get("/person/{id}", "incorrect-id")
                .then()
                .statusCode(404);
    }


    @Test
    void deleteByIdShouldFail() {
        given()
                .when().delete("/person/{id}", "incorrect-id")
                .then()
                .statusCode(404);
    }

}