package com.codegik.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class DataMapJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger(DataMapJob.class);

    @Override
    public void execute(JobExecutionContext context) {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String message = dataMap.getString("message");
        int count = dataMap.getInt("count");
        double value = dataMap.getDouble("value");

        logger.info("DataMapJob executed at: {} | message: {} | count: {} | value: {}",
            LocalDateTime.now(), message, count, value);

        dataMap.put("count", count + 1);
        dataMap.put("lastExecution", LocalDateTime.now().toString());
    }
}
