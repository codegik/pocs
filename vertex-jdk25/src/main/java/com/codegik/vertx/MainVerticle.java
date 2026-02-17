package com.codegik.vertx;

import com.codegik.vertx.handler.UserHandler;
import com.codegik.vertx.repository.UserRepository;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startPromise) {
        UserRepository userRepository = new UserRepository();
        UserHandler userHandler = new UserHandler(userRepository);

        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());

        // Define routes
        router.post("/api/users").handler(userHandler::createUser);
        router.get("/api/users").handler(userHandler::getAllUsers);
        router.get("/api/users/:id").handler(userHandler::getUser);
        router.put("/api/users/:id").handler(userHandler::updateUser);
        router.delete("/api/users/:id").handler(userHandler::deleteUser);

        // Health check endpoint
        router.get("/health").handler(ctx ->
            ctx.response()
                .setStatusCode(200)
                .putHeader("content-type", "application/json")
                .end("{\"status\":\"UP\"}")
        );

        int port = config().getInteger("http.port", 8080);

        vertx.createHttpServer()
            .requestHandler(router)
            .listen(port)
            .onSuccess(ignored -> {
                System.out.println("HTTP server started on port " + port);
                startPromise.complete();
            })
            .onFailure(startPromise::fail);
    }
}
