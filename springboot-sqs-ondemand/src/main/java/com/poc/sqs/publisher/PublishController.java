package com.poc.sqs.publisher;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/publish")
public class PublishController {

    private final SnsPublisher publisher;

    public PublishController(SnsPublisher publisher) {
        this.publisher = publisher;
    }

    public record PublishRequest(String message) {}

    @PostMapping
    public Map<String, String> publish(@RequestBody PublishRequest request) {
        return Map.of("messageId", publisher.publish(request.message()));
    }
}
