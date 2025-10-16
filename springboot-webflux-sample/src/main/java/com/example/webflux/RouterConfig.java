package com.example.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(UserHandler userHandler) {
        return RouterFunctions
                .route(GET("/api/users"), userHandler::listUsers)
                .andRoute(POST("/api/users"), userHandler::createUser)
                .andRoute(GET("/api/users/{id}"), userHandler::getUser);
    }
}
