package com.ywy.demo.concurent.example.atomic;

import com.ywy.demo.concurent.annotations.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author ve
 * @date 2020/3/12 20:04
 */
@ThreadSafe
public class AtomicExample6 {

    // 请求总数
    public static int clientTotal = 5000;
    // 同时并发请求数
    public static int threadTotal = 200;
    private static AtomicBoolean isHappened = new AtomicBoolean(); // false

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    System.out.println("e: " + e.getMessage());
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("isHappened:{}" + isHappened.get());
    }

    private static void test() {
        if (isHappened.compareAndSet(false, true)) {
            System.out.println("execute");
        }
    }
}
