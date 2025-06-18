package com.codegik.context.api;

import com.codegik.context.domain.Address;
import com.codegik.context.domain.User;
import com.codegik.context.repository.AddressRepository;
import com.codegik.context.repository.UserRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    private User testUser;

    private final String ADDRESSES_ENDPOINT = "/api/addresses";

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
        addressRepository.deleteAll();
        userRepository.deleteAll();

        User user = new User();
        user.setName("Test User");
        user.setEmail("test@example.com");
        testUser = userRepository.save(user);
    }

    @Test
    public void testGetAllAddresses() {
        Address testAddress = createTestAddress();

        given()
            .contentType(ContentType.JSON)
        .when()
            .get(ADDRESSES_ENDPOINT)
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("size()", is(1))
            .body("[0].street", equalTo(testAddress.getStreet()))
            .body("[0].city", equalTo(testAddress.getCity()))
            .body("[0].state", equalTo(testAddress.getState()))
            .body("[0].zipCode", equalTo(testAddress.getZipCode()))
            .body("[0].userId", equalTo(testUser.getId().intValue()));
    }

    @Test
    public void testGetAddressesByUserId() {
        Address testAddress = createTestAddress();

        given()
            .contentType(ContentType.JSON)
            .pathParam("userId", testUser.getId())
        .when()
            .get(ADDRESSES_ENDPOINT + "/user/{userId}")
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("size()", is(1))
            .body("[0].street", equalTo(testAddress.getStreet()));
    }

    @Test
    public void testGetAddressById() {
        Address savedAddress = createTestAddress();

        given()
            .contentType(ContentType.JSON)
            .pathParam("id", savedAddress.getId())
        .when()
            .get(ADDRESSES_ENDPOINT + "/{id}")
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("street", equalTo(savedAddress.getStreet()))
            .body("city", equalTo(savedAddress.getCity()))
            .body("state", equalTo(savedAddress.getState()))
            .body("zipCode", equalTo(savedAddress.getZipCode()))
            .body("userId", equalTo(testUser.getId().intValue()));
    }

    @Test
    public void testGetAddressByIdNotFound() {
        given()
            .contentType(ContentType.JSON)
            .pathParam("id", 999)
        .when()
            .get(ADDRESSES_ENDPOINT + "/{id}")
        .then()
            .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testCreateAddress() {
        Address address = new Address();
        address.setStreet("456 New St");
        address.setCity("New City");
        address.setState("NS");
        address.setZipCode("67890");
        address.setUserId(testUser.getId());

        given()
            .contentType(ContentType.JSON)
            .body(address)
        .when()
            .post(ADDRESSES_ENDPOINT)
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("id", notNullValue())
            .body("street", equalTo(address.getStreet()))
            .body("city", equalTo(address.getCity()))
            .body("state", equalTo(address.getState()))
            .body("zipCode", equalTo(address.getZipCode()))
            .body("userId", equalTo(testUser.getId().intValue()));
    }

    @Test
    public void testCreateAddressWithInvalidUserId() {
        Address address = new Address();
        address.setStreet("456 Invalid St");
        address.setCity("Invalid City");
        address.setState("IC");
        address.setZipCode("99999");
        address.setUserId(999L); // Non-existent user ID

        given()
            .contentType(ContentType.JSON)
            .body(address)
        .when()
            .post(ADDRESSES_ENDPOINT)
        .then()
            .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void testUpdateAddress() {
        Address savedAddress = createTestAddress();

        Address updatedAddress = new Address();
        updatedAddress.setStreet("789 Updated St");
        updatedAddress.setCity("Updated City");
        updatedAddress.setState("UC");
        updatedAddress.setZipCode("54321");
        // We're not changing the userId

        given()
            .contentType(ContentType.JSON)
            .body(updatedAddress)
            .pathParam("id", savedAddress.getId())
        .when()
            .put(ADDRESSES_ENDPOINT + "/{id}")
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("id", equalTo(savedAddress.getId().intValue()))
            .body("street", equalTo(updatedAddress.getStreet()))
            .body("city", equalTo(updatedAddress.getCity()))
            .body("state", equalTo(updatedAddress.getState()))
            .body("zipCode", equalTo(updatedAddress.getZipCode()))
            .body("userId", equalTo(testUser.getId().intValue()));
    }

    @Test
    public void testUpdateAddressNotFound() {
        Address updatedAddress = new Address();
        updatedAddress.setStreet("789 Updated St");
        updatedAddress.setCity("Updated City");
        updatedAddress.setState("UC");
        updatedAddress.setZipCode("54321");

        given()
            .contentType(ContentType.JSON)
            .body(updatedAddress)
            .pathParam("id", 999)
        .when()
            .put(ADDRESSES_ENDPOINT + "/{id}")
        .then()
            .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testDeleteAddress() {
        Address savedAddress = createTestAddress();

        given()
            .pathParam("id", savedAddress.getId())
        .when()
            .delete(ADDRESSES_ENDPOINT + "/{id}")
        .then()
            .statusCode(HttpStatus.NO_CONTENT.value());

        given()
            .pathParam("id", savedAddress.getId())
        .when()
            .get(ADDRESSES_ENDPOINT + "/{id}")
        .then()
            .statusCode(HttpStatus.NOT_FOUND.value());
    }

    private Address createTestAddress() {
        Address address = new Address();
        address.setStreet("123 Test St");
        address.setCity("Test City");
        address.setState("TS");
        address.setZipCode("12345");
        address.setUserId(testUser.getId());
        return addressRepository.save(address);
    }
}
