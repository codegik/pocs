package com.example.webflux;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public Mono<User> save(User user) {
        return Mono.fromCallable(() -> {
            if (user.getId() == null || user.getId().isEmpty()) {
                user.setId(UUID.randomUUID().toString());
            }
            users.put(user.getId(), user);
            return user;
        }).subscribeOn(Schedulers.boundedElastic());
    }

    public Flux<User> findAll() {
        return Mono.fromCallable(() -> users.values())
                .flatMapMany(Flux::fromIterable)
                .subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<User> findById(String id) {
        return Mono.fromCallable(() -> users.get(id))
                .subscribeOn(Schedulers.boundedElastic());
    }
}
