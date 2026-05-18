package com.poc.sqs;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.utility.DockerImageName;

public class LocalStackInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    static final LocalStackContainer LOCALSTACK = new LocalStackContainer(
            DockerImageName.parse("localstack/localstack:3.8"))
            .withServices(LocalStackContainer.Service.SNS, LocalStackContainer.Service.SQS)
            .withReuse(true);

    static {
        LOCALSTACK.start();
    }

    @Override
    public void initialize(ConfigurableApplicationContext ctx) {
        TestPropertyValues.of(
                "aws.region=" + LOCALSTACK.getRegion(),
                "aws.endpoint=" + LOCALSTACK.getEndpoint(),
                "aws.access-key=" + LOCALSTACK.getAccessKey(),
                "aws.secret-key=" + LOCALSTACK.getSecretKey(),
                "aws.topic-name=ondemand-topic-test"
        ).applyTo(ctx.getEnvironment());
    }
}
