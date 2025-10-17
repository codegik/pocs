package com.example.webflux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterConfig {
    private static final Logger logger = LoggerFactory.getLogger(RouterConfig.class);

    @Bean
    public RouterFunction<ServerResponse> routes(UserHandler userHandler) {
        return RouterFunctions
                .route(GET("/api/users"), request ->
                    CorrelationIdFilter.getCorrelationIdMono()
                        .flatMap(correlationId -> {
                            logger.info("[{}] Router: Routing GET /api/users request", correlationId);
                            return userHandler.listUsers(request);
                        })
                )
                .andRoute(POST("/api/users"), request ->
                    CorrelationIdFilter.getCorrelationIdMono()
                        .flatMap(correlationId -> {
                            logger.info("[{}] Router: Routing POST /api/users request", correlationId);
                            return userHandler.createUser(request);
                        })
                )
                .andRoute(GET("/api/users/{id}"), request ->
                    CorrelationIdFilter.getCorrelationIdMono()
                        .flatMap(correlationId -> {
                            logger.info("[{}] Router: Routing GET /api/users/{} request", correlationId, request.pathVariable("id"));
                            return userHandler.getUser(request);
                        })
                )
                .andRoute(GET("/api/block"), request ->
                    CorrelationIdFilter.getCorrelationIdMono()
                        .flatMap(correlationId -> {
                            logger.info("[{}] Router: Routing GET /api/block request", correlationId);
                            return userHandler.blockingEndpoint(request);
                        })
                );
    }
}
