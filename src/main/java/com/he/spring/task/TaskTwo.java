package com.he.spring.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.he.spring.util.Logs;

@Component
public class TaskTwo {
    @Scheduled(cron = "59 59 23 * * ?")
    public void run() {
        Logs.info(this, "任务二执行开始...........");
        Logs.info(this, "任务二执行结束...........");
    }
}
