package com.he.spring.task;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.he.spring.util.Logs;

@Component
public class TaskOne {
    @Scheduled(cron = "59 59 23 * * ? ")
    public void run() throws Exception {

        Logs.info(this, "任务一执行开始...........");
        TimeUnit.SECONDS.sleep(30);
        Logs.info(this, "任务一执行结束...........");
    }
}
