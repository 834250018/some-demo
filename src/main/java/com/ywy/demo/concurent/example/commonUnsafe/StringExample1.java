package com.ywy.demo.concurent.example.commonUnsafe;

import com.ywy.demo.concurent.annotations.ThreadNotSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 局部变量StringBuilder,属于堆栈封闭,则不会涉及到线程安全问题
 *
 * @author ve
 * @date 2020/3/12 19:19
 */
@ThreadNotSafe
@Slf4j
public class StringExample1 {

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发请求数
    public static int threadTotal = 200;

    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (Exception e) {
                    log.info("e: " + e.getMessage());
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}" + stringBuilder.length());
    }

    private static void update() {
        stringBuilder.append("1");
    }
}
