package com.codegik.context.api;

import com.codegik.context.domain.User;
import com.codegik.context.repository.UserRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@ApiIntegrationTest
public class UserControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private UserRepository userRepository;

    private final String USERS_ENDPOINT = "/api/users";

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
        userRepository.deleteAll();
    }

    @Test
    public void testGetAllUsers() {
        User testUser = new User();
        testUser.setName("Test User");
        testUser.setEmail("test@example.com");
        userRepository.save(testUser);

        given()
            .contentType(ContentType.JSON)
        .when()
            .get(USERS_ENDPOINT)
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("size()", is(1))
            .body("[0].name", equalTo("Test User"))
            .body("[0].email", equalTo("test@example.com"));
    }

    @Test
    public void testGetUserById() {
        User testUser = new User();
        testUser.setName("Test User");
        testUser.setEmail("test@example.com");
        User savedUser = userRepository.save(testUser);

        given()
            .contentType(ContentType.JSON)
            .pathParam("id", savedUser.getId())
        .when()
            .get(USERS_ENDPOINT + "/{id}")
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("name", equalTo("Test User"))
            .body("email", equalTo("test@example.com"));
    }

    @Test
    public void testGetUserByIdNotFound() {
        given()
            .contentType(ContentType.JSON)
            .pathParam("id", 999)
        .when()
            .get(USERS_ENDPOINT + "/{id}")
        .then()
            .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setName("New User");
        user.setEmail("new@example.com");

        given()
            .contentType(ContentType.JSON)
            .body(user)
        .when()
            .post(USERS_ENDPOINT)
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("id", notNullValue())
            .body("name", equalTo("New User"))
            .body("email", equalTo("new@example.com"));
    }

    @Test
    public void testUpdateUser() {
        User testUser = new User();
        testUser.setName("Test User");
        testUser.setEmail("test@example.com");
        User savedUser = userRepository.save(testUser);

        User updatedUser = new User();
        updatedUser.setName("Updated User");
        updatedUser.setEmail("updated@example.com");

        given()
            .contentType(ContentType.JSON)
            .body(updatedUser)
            .pathParam("id", savedUser.getId())
        .when()
            .put(USERS_ENDPOINT + "/{id}")
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("id", equalTo(savedUser.getId().intValue()))
            .body("name", equalTo("Updated User"))
            .body("email", equalTo("updated@example.com"));
    }

    @Test
    public void testUpdateUserNotFound() {
        User updatedUser = new User();
        updatedUser.setName("Updated User");
        updatedUser.setEmail("updated@example.com");

        given()
            .contentType(ContentType.JSON)
            .body(updatedUser)
            .pathParam("id", 999)
        .when()
            .put(USERS_ENDPOINT + "/{id}")
        .then()
            .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testDeleteUser() {
        User testUser = new User();
        testUser.setName("Test User");
        testUser.setEmail("test@example.com");
        User savedUser = userRepository.save(testUser);

        given()
            .pathParam("id", savedUser.getId())
        .when()
            .delete(USERS_ENDPOINT + "/{id}")
        .then()
            .statusCode(HttpStatus.NO_CONTENT.value());

        given()
            .pathParam("id", savedUser.getId())
        .when()
            .get(USERS_ENDPOINT + "/{id}")
        .then()
            .statusCode(HttpStatus.NOT_FOUND.value());
    }
}
