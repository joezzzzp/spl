package com.learn.spl.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author created by zzz at 2019/11/1 14:16
 */
//@Component
public class TestTask {

    private Logger logger = LoggerFactory.getLogger(TestTask.class);

    @Scheduled(cron = "* * * * * ?")
    public void test1() throws InterruptedException {
        logger.info("test1执行");
        TimeUnit.SECONDS.sleep(3);
        logger.info("test1结束");
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void test2() throws InterruptedException {
        logger.info("test2执行");
        TimeUnit.SECONDS.sleep(5);
        logger.info("test2结束");
    }
}
