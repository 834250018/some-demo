package com.ywy.demo.concurent.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ve
 * @date 2020/3/13 22:25
 */
@Slf4j public class ThreadPoolExample3 {
    public static void main(String[] args) {

        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            exec.execute(() -> {
                log.info("task:{}", index);
            });

        }
        exec.shutdown();
    }
}
