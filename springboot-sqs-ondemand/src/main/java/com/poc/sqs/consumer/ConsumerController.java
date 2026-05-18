package com.poc.sqs.consumer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {

    private final ConsumerManager manager;

    public ConsumerController(ConsumerManager manager) {
        this.manager = manager;
    }

    public record ConsumerView(String id, String queueName, String queueUrl, List<String> received) {
        static ConsumerView of(Consumer c) {
            return new ConsumerView(c.id(), c.queueName(), c.queueUrl(), c.received());
        }
    }

    @GetMapping
    public List<ConsumerView> list() {
        return manager.list().stream().map(ConsumerView::of).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumerView> get(@PathVariable String id) {
        Consumer c = manager.get(id);
        return c == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(ConsumerView.of(c));
    }

    @PostMapping
    public ConsumerView add() {
        return ConsumerView.of(manager.add());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable String id) {
        return manager.remove(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/scale")
    public Map<String, Object> scale(@RequestParam int target) {
        var consumers = manager.scaleTo(target);
        return Map.of("size", consumers.size(),
                "consumers", consumers.stream().map(ConsumerView::of).toList());
    }
}
