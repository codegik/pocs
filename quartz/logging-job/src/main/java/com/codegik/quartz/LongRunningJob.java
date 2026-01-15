package com.codegik.quartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@DisallowConcurrentExecution
public class LongRunningJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger(LongRunningJob.class);

    @Override
    public void execute(JobExecutionContext context) {
        logger.info("LongRunningJob started at: {}", LocalDateTime.now());

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            logger.warn("Job was interrupted");
            Thread.currentThread().interrupt();
            return;
        }

        logger.info("LongRunningJob finished at: {}", LocalDateTime.now());
    }
}
