package com.codegik.quartz;

import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.UnableToInterruptJobException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class InterruptibleJob implements InterruptableJob {
    private static final Logger logger = LoggerFactory.getLogger(InterruptibleJob.class);
    private volatile boolean interrupted = false;

    @Override
    public void execute(JobExecutionContext context) {
        logger.info("InterruptibleJob started at: {}", LocalDateTime.now());

        for (int i = 0; i < 20; i++) {
            if (interrupted) {
                logger.warn("InterruptibleJob was interrupted at iteration {}", i);
                return;
            }

            logger.info("InterruptibleJob processing iteration {}/20", i + 1);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.warn("InterruptibleJob sleep was interrupted");
                Thread.currentThread().interrupt();
                return;
            }
        }

        logger.info("InterruptibleJob completed at: {}", LocalDateTime.now());
    }

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        logger.info("InterruptibleJob interrupt requested");
        interrupted = true;
    }
}
