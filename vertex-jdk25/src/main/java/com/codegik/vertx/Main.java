package com.codegik.vertx;

import io.vertx.core.Vertx;

public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new MainVerticle())
            .onSuccess(id -> System.out.println("Application started successfully"))
            .onFailure(err -> {
                System.err.println("Failed to start application: " + err.getMessage());
                vertx.close();
            });
    }
}
