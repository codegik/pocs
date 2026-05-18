package com.poc.sqs.publisher;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

@Service
public class SnsPublisher {

    private final SnsClient sns;
    private final String topicArn;

    public SnsPublisher(SnsClient sns, String topicArn) {
        this.sns = sns;
        this.topicArn = topicArn;
    }

    public String publish(String message) {
        return sns.publish(PublishRequest.builder()
                .topicArn(topicArn)
                .message(message)
                .build()).messageId();
    }
}
