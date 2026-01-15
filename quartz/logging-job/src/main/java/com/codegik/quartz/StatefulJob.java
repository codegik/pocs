package com.codegik.quartz;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class StatefulJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger(StatefulJob.class);

    @Override
    public void execute(JobExecutionContext context) {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        int executionCount = dataMap.containsKey("executionCount") ? dataMap.getInt("executionCount") : 0;
        executionCount++;

        double total = dataMap.containsKey("total") ? dataMap.getDouble("total") : 0.0;
        double newValue = Math.random() * 100;
        total += newValue;

        dataMap.put("executionCount", executionCount);
        dataMap.put("total", total);
        dataMap.put("lastValue", newValue);
        dataMap.put("average", total / executionCount);

        logger.info(String.format("StatefulJob executed at: %s | Execution #%d | New value: %.2f | Total: %.2f | Average: %.2f",
            LocalDateTime.now(), executionCount, newValue, total, total / executionCount));
    }
}
