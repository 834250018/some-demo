package com.ywy.demo.concurent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ve
 * @date 2020/3/13 19:31
 */
@Slf4j public class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService exex = Executors.newCachedThreadPool();
        Future<String> future = exex.submit(new MyCallable());
        log.info("do something in main");
        Thread.sleep(1000L);
        String result = future.get();
        System.out.println(result);
    }

    static class MyCallable implements Callable<String> {
        @Override public String call() throws Exception {
            log.info("do something in callable");
            Thread.sleep(10000L);
            return "Done";
        }
    }
}
