package com.example.webflux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public Flux<User> listUsers() {
        logger.info("Listing all users");
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public Mono<User> createUser(@RequestBody User user) {
        logger.info("Saving user: {}", user.getName());
        return userRepository.save(user)
                .doOnSuccess(savedUser ->
                    logger.info("User created with ID: {}", savedUser.getId())
                );
    }

    @GetMapping("/users/{id}")
    public Mono<User> getUser(@PathVariable String id) {
        logger.info("Fetching user with ID: {}", id);
        return userRepository.findById(id)
                .doOnSuccess(user -> {
                    if (user != null) {
                        logger.info("User found: {}", user.getName());
                    } else {
                        logger.warn("User not found with ID: {}", id);
                    }
                });
    }

    @GetMapping(value = "/block", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> blockingEndpoint() {
        return userRepository.findAllBlocking();
    }
}

