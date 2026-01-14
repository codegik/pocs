package com.codegik.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Main {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail job = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("simpleJob")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("simpleTrigger")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }
}
