package com.codegik.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.codec.BodyCodec;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(VertxExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserCrudIntegrationTest {

    private static final int TEST_PORT = 8888;
    private static WebClient webClient;
    private static String deploymentId;

    @BeforeAll
    static void setup(Vertx vertx, VertxTestContext testContext) {
        webClient = WebClient.create(vertx);

        MainVerticle verticle = new MainVerticle();
        JsonObject config = new JsonObject().put("http.port", TEST_PORT);

        vertx.deployVerticle(verticle,
            new io.vertx.core.DeploymentOptions().setConfig(config))
            .onSuccess(id -> {
                deploymentId = id;
                testContext.completeNow();
            })
            .onFailure(testContext::failNow);
    }

    @AfterAll
    static void cleanup(Vertx vertx) {
        if (webClient != null) {
            webClient.close();
        }
    }

    @Test
    @Order(1)
    void testHealthEndpoint(Vertx vertx, VertxTestContext testContext) {
        webClient.get(TEST_PORT, "localhost", "/health")
            .as(BodyCodec.jsonObject())
            .send()
            .onSuccess(response -> {
                testContext.verify(() -> {
                    assertEquals(200, response.statusCode());
                    assertEquals("UP", response.body().getString("status"));
                    testContext.completeNow();
                });
            })
            .onFailure(testContext::failNow);
    }

    @Test
    @Order(2)
    void testCreateUser(Vertx vertx, VertxTestContext testContext) {
        JsonObject user = new JsonObject()
            .put("name", "John Doe")
            .put("email", "john.doe@example.com");

        webClient.post(TEST_PORT, "localhost", "/api/users")
            .as(BodyCodec.jsonObject())
            .sendJsonObject(user)
            .onSuccess(response -> {
                testContext.verify(() -> {
                    assertEquals(201, response.statusCode());
                    JsonObject body = response.body();
                    assertNotNull(body.getString("id"));
                    assertEquals("John Doe", body.getString("name"));
                    assertEquals("john.doe@example.com", body.getString("email"));
                    testContext.completeNow();
                });
            })
            .onFailure(testContext::failNow);
    }

    @Test
    @Order(3)
    void testCreateUserWithId(Vertx vertx, VertxTestContext testContext) {
        JsonObject user = new JsonObject()
            .put("id", "user-123")
            .put("name", "Jane Smith")
            .put("email", "jane.smith@example.com");

        webClient.post(TEST_PORT, "localhost", "/api/users")
            .as(BodyCodec.jsonObject())
            .sendJsonObject(user)
            .onSuccess(response -> {
                testContext.verify(() -> {
                    assertEquals(201, response.statusCode());
                    JsonObject body = response.body();
                    assertEquals("user-123", body.getString("id"));
                    assertEquals("Jane Smith", body.getString("name"));
                    assertEquals("jane.smith@example.com", body.getString("email"));
                    testContext.completeNow();
                });
            })
            .onFailure(testContext::failNow);
    }

    @Test
    @Order(4)
    void testGetUserById(Vertx vertx, VertxTestContext testContext) {
        webClient.get(TEST_PORT, "localhost", "/api/users/user-123")
            .as(BodyCodec.jsonObject())
            .send()
            .onSuccess(response -> {
                testContext.verify(() -> {
                    assertEquals(200, response.statusCode());
                    JsonObject body = response.body();
                    assertEquals("user-123", body.getString("id"));
                    assertEquals("Jane Smith", body.getString("name"));
                    assertEquals("jane.smith@example.com", body.getString("email"));
                    testContext.completeNow();
                });
            })
            .onFailure(testContext::failNow);
    }

    @Test
    @Order(5)
    void testGetUserNotFound(Vertx vertx, VertxTestContext testContext) {
        webClient.get(TEST_PORT, "localhost", "/api/users/non-existent")
            .as(BodyCodec.jsonObject())
            .send()
            .onSuccess(response -> {
                testContext.verify(() -> {
                    assertEquals(404, response.statusCode());
                    JsonObject body = response.body();
                    assertEquals("User not found", body.getString("error"));
                    testContext.completeNow();
                });
            })
            .onFailure(testContext::failNow);
    }

    @Test
    @Order(6)
    void testGetAllUsers(Vertx vertx, VertxTestContext testContext) {
        webClient.get(TEST_PORT, "localhost", "/api/users")
            .as(BodyCodec.jsonArray())
            .send()
            .onSuccess(response -> {
                testContext.verify(() -> {
                    assertEquals(200, response.statusCode());
                    assertTrue(response.body().size() >= 2, "Should have at least 2 users");
                    testContext.completeNow();
                });
            })
            .onFailure(testContext::failNow);
    }

    @Test
    @Order(7)
    void testUpdateUser(Vertx vertx, VertxTestContext testContext) {
        JsonObject updatedUser = new JsonObject()
            .put("name", "Jane Doe")
            .put("email", "jane.doe@example.com");

        webClient.put(TEST_PORT, "localhost", "/api/users/user-123")
            .as(BodyCodec.jsonObject())
            .sendJsonObject(updatedUser)
            .onSuccess(response -> {
                testContext.verify(() -> {
                    assertEquals(200, response.statusCode());
                    JsonObject body = response.body();
                    assertEquals("user-123", body.getString("id"));
                    assertEquals("Jane Doe", body.getString("name"));
                    assertEquals("jane.doe@example.com", body.getString("email"));
                    testContext.completeNow();
                });
            })
            .onFailure(testContext::failNow);
    }

    @Test
    @Order(8)
    void testUpdateNonExistentUser(Vertx vertx, VertxTestContext testContext) {
        JsonObject updatedUser = new JsonObject()
            .put("name", "Nobody")
            .put("email", "nobody@example.com");

        webClient.put(TEST_PORT, "localhost", "/api/users/non-existent")
            .as(BodyCodec.jsonObject())
            .sendJsonObject(updatedUser)
            .onSuccess(response -> {
                testContext.verify(() -> {
                    assertEquals(404, response.statusCode());
                    JsonObject body = response.body();
                    assertEquals("User not found", body.getString("error"));
                    testContext.completeNow();
                });
            })
            .onFailure(testContext::failNow);
    }

    @Test
    @Order(9)
    void testDeleteUser(Vertx vertx, VertxTestContext testContext) {
        webClient.delete(TEST_PORT, "localhost", "/api/users/user-123")
            .send()
            .onSuccess(response -> {
                testContext.verify(() -> {
                    assertEquals(204, response.statusCode());
                    testContext.completeNow();
                });
            })
            .onFailure(testContext::failNow);
    }

    @Test
    @Order(10)
    void testDeleteNonExistentUser(Vertx vertx, VertxTestContext testContext) {
        webClient.delete(TEST_PORT, "localhost", "/api/users/user-123")
            .as(BodyCodec.jsonObject())
            .send()
            .onSuccess(response -> {
                testContext.verify(() -> {
                    assertEquals(404, response.statusCode());
                    JsonObject body = response.body();
                    assertEquals("User not found", body.getString("error"));
                    testContext.completeNow();
                });
            })
            .onFailure(testContext::failNow);
    }

    @Test
    @Order(11)
    void testCreateUserWithInvalidData(Vertx vertx, VertxTestContext testContext) {
        webClient.post(TEST_PORT, "localhost", "/api/users")
            .as(BodyCodec.jsonObject())
            .sendBuffer(io.vertx.core.buffer.Buffer.buffer("invalid json"))
            .onSuccess(response -> {
                testContext.verify(() -> {
                    assertEquals(400, response.statusCode());
                    JsonObject body = response.body();
                    assertEquals("Invalid request body", body.getString("error"));
                    testContext.completeNow();
                });
            })
            .onFailure(testContext::failNow);
    }
}
