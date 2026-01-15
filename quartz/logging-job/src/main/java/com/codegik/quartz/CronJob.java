package com.codegik.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class CronJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger(CronJob.class);

    @Override
    public void execute(JobExecutionContext context) {
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();

        logger.info("CronJob executed at: {} | Day: {} | Hour: {} | Minute: {}",
            now, dayOfWeek, now.getHour(), now.getMinute());
    }
}
