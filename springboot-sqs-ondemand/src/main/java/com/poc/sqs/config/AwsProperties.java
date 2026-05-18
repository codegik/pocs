package com.poc.sqs.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "aws")
public record AwsProperties(
        String region,
        String endpoint,
        String accessKey,
        String secretKey,
        String topicName
) {}
