package com.example.webflux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {
    private static final Logger logger = LoggerFactory.getLogger(UserHandler.class);
    private final UserRepository userRepository;

    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse> listUsers(ServerRequest request) {
        return CorrelationIdFilter.getCorrelationIdMono()
                .flatMap(correlationId -> {
                    logger.info("[{}] Listing all users", correlationId);
                    return ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(userRepository.findAll(), User.class);
                });
    }

    public Mono<ServerResponse> createUser(ServerRequest request) {
        return CorrelationIdFilter.getCorrelationIdMono()
                .flatMap(correlationId -> {
                    logger.info("[{}] Creating new user", correlationId);
                    return request.bodyToMono(User.class)
                            .flatMap(user -> {
                                logger.info("[{}] Saving user: {}", correlationId, user.getName());
                                return userRepository.save(user);
                            })
                            .flatMap(user -> {
                                logger.info("[{}] User created with ID: {}", correlationId, user.getId());
                                return ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(user);
                            });
                });
    }

    public Mono<ServerResponse> getUser(ServerRequest request) {
        String id = request.pathVariable("id");
        return CorrelationIdFilter.getCorrelationIdMono()
                .flatMap(correlationId -> {
                    logger.info("[{}] Fetching user with ID: {}", correlationId, id);
                    return userRepository.findById(id)
                            .flatMap(user -> {
                                logger.info("[{}] User found: {}", correlationId, user.getName());
                                return ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(user);
                            })
                            .switchIfEmpty(Mono.defer(() -> {
                                logger.warn("[{}] User not found with ID: {}", correlationId, id);
                                return ServerResponse.notFound().build();
                            }));
                });
    }

    public Mono<ServerResponse> blockingEndpoint(ServerRequest request) {
        return CorrelationIdFilter.getCorrelationIdMono()
                .flatMap(correlationId -> {
                    logger.info("[{}] Starting blocking operation", correlationId);
                    return Mono.fromCallable(() -> {
                        Thread.sleep(5000);
                        logger.info("[{}] Blocking operation completed", correlationId);
                        return "Blocked event loop for 5 seconds";
                    }).flatMap(result -> ServerResponse.ok()
                            .contentType(MediaType.TEXT_PLAIN)
                            .bodyValue(result));
                });
    }
}
