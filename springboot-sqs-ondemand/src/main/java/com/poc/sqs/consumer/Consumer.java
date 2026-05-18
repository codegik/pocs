package com.poc.sqs.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.SubscribeRequest;
import software.amazon.awssdk.services.sns.model.UnsubscribeRequest;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.DeleteQueueRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueAttributesRequest;
import software.amazon.awssdk.services.sqs.model.QueueAttributeName;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.SetQueueAttributesRequest;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Consumer {

    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    private final String id;
    private final String queueName;
    private final String queueUrl;
    private final String queueArn;
    private final String subscriptionArn;
    private final SqsClient sqs;
    private final SnsClient sns;
    private final Thread worker;
    private final AtomicBoolean running = new AtomicBoolean(true);
    private final List<String> received = new CopyOnWriteArrayList<>();

    public Consumer(String id, String topicArn, SqsClient sqs, SnsClient sns) {
        this.id = id;
        this.sqs = sqs;
        this.sns = sns;
        this.queueName = "consumer-" + id;
        this.queueUrl = sqs.createQueue(CreateQueueRequest.builder().queueName(queueName).build()).queueUrl();
        this.queueArn = sqs.getQueueAttributes(GetQueueAttributesRequest.builder()
                .queueUrl(queueUrl)
                .attributeNames(QueueAttributeName.QUEUE_ARN)
                .build()).attributes().get(QueueAttributeName.QUEUE_ARN);

        String policy = """
                {"Version":"2012-10-17","Statement":[{"Effect":"Allow","Principal":{"AWS":"*"},
                "Action":"sqs:SendMessage","Resource":"%s",
                "Condition":{"ArnEquals":{"aws:SourceArn":"%s"}}}]}
                """.formatted(queueArn, topicArn);
        sqs.setQueueAttributes(SetQueueAttributesRequest.builder()
                .queueUrl(queueUrl)
                .attributes(Map.of(QueueAttributeName.POLICY, policy))
                .build());

        this.subscriptionArn = sns.subscribe(SubscribeRequest.builder()
                .topicArn(topicArn)
                .protocol("sqs")
                .endpoint(queueArn)
                .attributes(Map.of("RawMessageDelivery", "true"))
                .returnSubscriptionArn(true)
                .build()).subscriptionArn();

        this.worker = Thread.ofVirtual().name("consumer-" + id).start(this::poll);
        log.info("Consumer {} started, queue={}", id, queueUrl);
    }

    private void poll() {
        while (running.get()) {
            try {
                var resp = sqs.receiveMessage(ReceiveMessageRequest.builder()
                        .queueUrl(queueUrl)
                        .maxNumberOfMessages(10)
                        .waitTimeSeconds(1)
                        .build());
                for (var msg : resp.messages()) {
                    received.add(msg.body());
                    log.info("Consumer {} received: {}", id, msg.body());
                    sqs.deleteMessage(DeleteMessageRequest.builder()
                            .queueUrl(queueUrl).receiptHandle(msg.receiptHandle()).build());
                }
            } catch (Exception e) {
                if (running.get()) log.warn("Consumer {} poll error: {}", id, e.getMessage());
            }
        }
    }

    public void shutdown() {
        running.set(false);
        worker.interrupt();
        try { worker.join(2000); } catch (InterruptedException ignored) { Thread.currentThread().interrupt(); }
        try { sns.unsubscribe(UnsubscribeRequest.builder().subscriptionArn(subscriptionArn).build()); } catch (Exception ignored) {}
        try { sqs.deleteQueue(DeleteQueueRequest.builder().queueUrl(queueUrl).build()); } catch (Exception ignored) {}
        log.info("Consumer {} stopped, queue {} deleted", id, queueUrl);
    }

    public String id() { return id; }
    public String queueName() { return queueName; }
    public String queueUrl() { return queueUrl; }
    public List<String> received() { return List.copyOf(received); }
}
