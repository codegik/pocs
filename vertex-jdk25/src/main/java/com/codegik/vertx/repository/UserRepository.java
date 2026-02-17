package com.codegik.vertx.repository;

import com.codegik.vertx.model.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public User create(User user) {
        if (user.getId() == null || user.getId().isEmpty()) {
            user.setId(UUID.randomUUID().toString());
        }
        users.put(user.getId(), user);
        return user;
    }

    public Optional<User> findById(String id) {
        return Optional.ofNullable(users.get(id));
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public Optional<User> update(String id, User user) {
        if (!users.containsKey(id)) {
            return Optional.empty();
        }
        user.setId(id);
        users.put(id, user);
        return Optional.of(user);
    }

    public boolean delete(String id) {
        return users.remove(id) != null;
    }
}
