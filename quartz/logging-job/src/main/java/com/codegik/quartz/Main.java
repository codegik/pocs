package com.codegik.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        scheduler.getListenerManager().addJobListener(new CustomJobListener("GlobalJobListener"));

        scheduleSimpleJob(scheduler);
        scheduleDataMapJob(scheduler);
        scheduleCronJob(scheduler);
        scheduleStatefulJob(scheduler);
        scheduleLongRunningJob(scheduler);
        scheduleInterruptibleJob(scheduler);

        scheduler.start();
        logger.info("Scheduler started - All jobs scheduled");

        Thread.sleep(30000);

        logger.info("Interrupting the interruptible job...");
        scheduler.interrupt(JobKey.jobKey("interruptibleJob"));

        Thread.sleep(10000);

        logger.info("Shutting down scheduler...");
        scheduler.shutdown(true);
        logger.info("Scheduler shut down");
    }

    private static void scheduleSimpleJob(Scheduler scheduler) throws SchedulerException {
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
        logger.info("Scheduled SimpleJob with 5-second interval");
    }

    private static void scheduleDataMapJob(Scheduler scheduler) throws SchedulerException {
        JobDetail job = JobBuilder.newJob(DataMapJob.class)
                .withIdentity("dataMapJob")
                .usingJobData("message", "Hello from JobDataMap")
                .usingJobData("count", 0)
                .usingJobData("value", 42.5)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("dataMapTrigger")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(7)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(job, trigger);
        logger.info("Scheduled DataMapJob with JobDataMap parameters");
    }

    private static void scheduleCronJob(Scheduler scheduler) throws SchedulerException {
        JobDetail job = JobBuilder.newJob(CronJob.class)
                .withIdentity("cronJob")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("cronTrigger")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                .build();

        scheduler.scheduleJob(job, trigger);
        logger.info("Scheduled CronJob with cron expression: every 10 seconds");
    }

    private static void scheduleStatefulJob(Scheduler scheduler) throws SchedulerException {
        JobDetail job = JobBuilder.newJob(StatefulJob.class)
                .withIdentity("statefulJob")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("statefulTrigger")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(6)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(job, trigger);
        logger.info("Scheduled StatefulJob that persists data across executions");
    }

    private static void scheduleLongRunningJob(Scheduler scheduler) throws SchedulerException {
        JobDetail job = JobBuilder.newJob(LongRunningJob.class)
                .withIdentity("longRunningJob")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("longRunningTrigger")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)
                        .withMisfireHandlingInstructionNextWithExistingCount())
                .build();

        scheduler.scheduleJob(job, trigger);
        logger.info("Scheduled LongRunningJob with misfire handling");
    }

    private static void scheduleInterruptibleJob(Scheduler scheduler) throws SchedulerException {
        JobDetail job = JobBuilder.newJob(InterruptibleJob.class)
                .withIdentity("interruptibleJob")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("interruptibleTrigger")
                .startNow()
                .build();

        scheduler.scheduleJob(job, trigger);
        logger.info("Scheduled InterruptibleJob that can be cancelled");
    }
}
