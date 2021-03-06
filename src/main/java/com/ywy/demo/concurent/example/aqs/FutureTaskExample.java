package com.ywy.demo.concurent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.FutureTask;

/**
 * @author ve
 * @date 2020/3/13 19:35
 */
@Slf4j
public class FutureTaskExample {
    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            log.info("do something in callable");
            Thread.sleep(5000L);
            return "Done";
        });
        new Thread(futureTask).start();
        log.info("do something in main");
        Thread.sleep(1000L);
        String result = futureTask.get();
        log.info("result: {}", result);

    }
}
