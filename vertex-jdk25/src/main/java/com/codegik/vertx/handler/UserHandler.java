package com.codegik.vertx.handler;

import com.codegik.vertx.model.User;
import com.codegik.vertx.repository.UserRepository;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class UserHandler {
    private final UserRepository repository;

    public UserHandler(UserRepository repository) {
        this.repository = repository;
    }

    public void createUser(RoutingContext ctx) {
        try {
            JsonObject json = ctx.body().asJsonObject();
            User user = User.fromJson(json);
            User created = repository.create(user);

            ctx.response()
                .setStatusCode(201)
                .putHeader("content-type", "application/json")
                .end(created.toJson().encode());
        } catch (Exception e) {
            ctx.response()
                .setStatusCode(400)
                .putHeader("content-type", "application/json")
                .end(new JsonObject().put("error", "Invalid request body").encode());
        }
    }

    public void getUser(RoutingContext ctx) {
        String id = ctx.pathParam("id");
        repository.findById(id).ifPresentOrElse(
            user -> ctx.response()
                .setStatusCode(200)
                .putHeader("content-type", "application/json")
                .end(user.toJson().encode()),
            () -> ctx.response()
                .setStatusCode(404)
                .putHeader("content-type", "application/json")
                .end(new JsonObject().put("error", "User not found").encode())
        );
    }

    public void getAllUsers(RoutingContext ctx) {
        JsonArray jsonArray = new JsonArray();
        repository.findAll().forEach(user -> jsonArray.add(user.toJson()));

        ctx.response()
            .setStatusCode(200)
            .putHeader("content-type", "application/json")
            .end(jsonArray.encode());
    }

    public void updateUser(RoutingContext ctx) {
        String id = ctx.pathParam("id");
        try {
            JsonObject json = ctx.body().asJsonObject();
            User user = User.fromJson(json);

            repository.update(id, user).ifPresentOrElse(
                updated -> ctx.response()
                    .setStatusCode(200)
                    .putHeader("content-type", "application/json")
                    .end(updated.toJson().encode()),
                () -> ctx.response()
                    .setStatusCode(404)
                    .putHeader("content-type", "application/json")
                    .end(new JsonObject().put("error", "User not found").encode())
            );
        } catch (Exception e) {
            ctx.response()
                .setStatusCode(400)
                .putHeader("content-type", "application/json")
                .end(new JsonObject().put("error", "Invalid request body").encode());
        }
    }

    public void deleteUser(RoutingContext ctx) {
        String id = ctx.pathParam("id");
        if (repository.delete(id)) {
            ctx.response()
                .setStatusCode(204)
                .end();
        } else {
            ctx.response()
                .setStatusCode(404)
                .putHeader("content-type", "application/json")
                .end(new JsonObject().put("error", "User not found").encode());
        }
    }
}
