package com.poc.sqs.consumer;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sqs.SqsClient;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ConsumerManager {

    private final SqsClient sqs;
    private final SnsClient sns;
    private final String topicArn;
    private final Map<String, Consumer> consumers = new ConcurrentHashMap<>();

    public ConsumerManager(SqsClient sqs, SnsClient sns, String topicArn) {
        this.sqs = sqs;
        this.sns = sns;
        this.topicArn = topicArn;
    }

    public synchronized Consumer add() {
        String id = UUID.randomUUID().toString().substring(0, 8);
        Consumer c = new Consumer(id, topicArn, sqs, sns);
        consumers.put(id, c);
        return c;
    }

    public synchronized boolean remove(String id) {
        Consumer c = consumers.remove(id);
        if (c == null) return false;
        c.shutdown();
        return true;
    }

    public synchronized List<Consumer> scaleTo(int target) {
        while (consumers.size() < target) add();
        while (consumers.size() > target) {
            String anyId = consumers.keySet().iterator().next();
            remove(anyId);
        }
        return list();
    }

    public List<Consumer> list() {
        return List.copyOf(consumers.values());
    }

    public Consumer get(String id) {
        return consumers.get(id);
    }

    public int size() {
        return consumers.size();
    }

    @PreDestroy
    public void shutdown() {
        consumers.values().forEach(Consumer::shutdown);
        consumers.clear();
    }
}
