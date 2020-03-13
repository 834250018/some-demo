package com.ywy.demo.concurent.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 两种定时器,定时执行代码
 * @author ve
 * @date 2020/3/13 22:25
 */
@Slf4j
public class ThreadPoolExample {
    public static void main(String[] args) {

        ScheduledExecutorService exec = Executors.newScheduledThreadPool(5);
       /* exec.schedule(() -> {
            log.info("task:{}", 3);
        }, 3, TimeUnit.SECONDS);*/
        exec.scheduleAtFixedRate(() -> {
            log.info("task:{}");
        }, 3, 5, TimeUnit.SECONDS);

//        exec.shutdown();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("timer run");
            }
        }, new Date(), 5 *1000L);
    }
}
