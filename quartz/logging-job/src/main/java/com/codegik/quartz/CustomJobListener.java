package com.codegik.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDateTime;

public class CustomJobListener implements JobListener {
    private static final Logger logger = LoggerFactory.getLogger(CustomJobListener.class);
    private final String name;

    public CustomJobListener(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        String jobName = context.getJobDetail().getKey().getName();
        logger.info("[LISTENER] Job '{}' is about to be executed", jobName);
        context.put("startTime", LocalDateTime.now());
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        String jobName = context.getJobDetail().getKey().getName();
        logger.warn("[LISTENER] Job '{}' execution was vetoed", jobName);
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        String jobName = context.getJobDetail().getKey().getName();
        LocalDateTime startTime = (LocalDateTime) context.get("startTime");
        LocalDateTime endTime = LocalDateTime.now();

        if (startTime != null) {
            Duration duration = Duration.between(startTime, endTime);
            logger.info("[LISTENER] Job '{}' completed in {} ms", jobName, duration.toMillis());
        }

        if (jobException != null) {
            logger.error("[LISTENER] Job '{}' threw exception: {}", jobName, jobException.getMessage());
        }
    }
}
