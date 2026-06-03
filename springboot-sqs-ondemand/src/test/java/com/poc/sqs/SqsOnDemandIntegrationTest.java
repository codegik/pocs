package com.poc.sqs;

import com.poc.sqs.consumer.Consumer;
import com.poc.sqs.consumer.ConsumerManager;
import com.poc.sqs.publisher.SnsPublisher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.ListQueuesRequest;
import software.amazon.awssdk.services.sqs.model.QueueDoesNotExistException;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@SpringBootTest
@ContextConfiguration(initializers = LocalStackInitializer.class)
class SqsOnDemandIntegrationTest {

    @Autowired ConsumerManager manager;
    @Autowired SnsPublisher publisher;
    @Autowired SqsClient sqs;

    @AfterEach
    void cleanup() {
        manager.scaleTo(0);
    }

    @Test
    void singleConsumerReceivesPublishedMessage() {
        Consumer c = manager.add();

        publisher.publish("hello-1");

        await().atMost(Duration.ofSeconds(15)).untilAsserted(() ->
                assertThat(c.received()).contains("hello-1"));
    }

    @Test
    void scalingUpCreatesNewQueueAndAllConsumersReceiveMessage() {
        manager.scaleTo(3);
        List<Consumer> consumers = manager.list();
        assertThat(consumers).hasSize(3);

        for (Consumer c : consumers) {
            assertThat(listQueues()).contains(c.queueName());
        }

        publisher.publish("fanout");

        await().atMost(Duration.ofSeconds(20)).untilAsserted(() -> {
            for (Consumer c : consumers) {
                assertThat(c.received()).contains("fanout");
            }
        });
    }

    @Test
    void scalingDownRemovesQueues() {
        manager.scaleTo(3);
        List<String> initialQueues = manager.list().stream().map(Consumer::queueName).toList();
        assertThat(initialQueues).hasSize(3);

        manager.scaleTo(1);
        assertThat(manager.size()).isEqualTo(1);

        String survivor = manager.list().get(0).queueName();
        await().atMost(Duration.ofSeconds(15)).untilAsserted(() -> {
            for (String name : initialQueues) {
                if (name.equals(survivor)) continue;
                assertThat(queueExists(name)).isFalse();
            }
        });
    }

    @Test
    void removingConsumerByIdDeletesItsQueue() {
        Consumer a = manager.add();
        Consumer b = manager.add();

        boolean removed = manager.remove(a.id());
        assertThat(removed).isTrue();
        assertThat(manager.size()).isEqualTo(1);

        await().atMost(Duration.ofSeconds(15)).untilAsserted(() ->
                assertThat(queueExists(a.queueName())).isFalse());
        assertThat(queueExists(b.queueName())).isTrue();
    }

    private List<String> listQueues() {
        return sqs.listQueues(ListQueuesRequest.builder().build()).queueUrls().stream()
                .map(url -> url.substring(url.lastIndexOf('/') + 1))
                .toList();
    }

    private boolean queueExists(String name) {
        try {
            sqs.getQueueUrl(GetQueueUrlRequest.builder().queueName(name).build());
            return true;
        } catch (QueueDoesNotExistException e) {
            return false;
        }
    }
}
