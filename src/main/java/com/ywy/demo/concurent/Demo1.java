package com.ywy.demo.concurent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author ve
 * @date 2020/3/2 0:20
 */
public class Demo1 {

    private static int threadTotal = 50;
    private static int clientTotal = 5000;
    private static long count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });
        }
        executorService.awaitTermination(2, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println("count:{}" + count);
    }

    public static void add() {
        count++;
    }
}
