package com.codegik.vertx.model;

import io.vertx.core.json.JsonObject;

public class User {
    private String id;
    private String name;
    private String email;

    public User() {
    }

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public JsonObject toJson() {
        return new JsonObject()
            .put("id", id)
            .put("name", name)
            .put("email", email);
    }

    public static User fromJson(JsonObject json) {
        return new User(
            json.getString("id"),
            json.getString("name"),
            json.getString("email")
        );
    }
}
