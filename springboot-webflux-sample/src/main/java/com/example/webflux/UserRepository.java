package com.example.webflux;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public Mono<User> save(User user) {
        if (user.getId() == null || user.getId().isEmpty()) {
            user.setId(UUID.randomUUID().toString());
        }
        users.put(user.getId(), user);

        return Mono.just(user);
    }

    public Flux<User> findAll() {
        return Flux.fromIterable(users.values());
    }

    public List<User> findAllBlocking() {
        return users.values().stream().toList();
    }

    public Mono<User> findById(String id) {
        return Mono.just(users.get(id));
    }
}
