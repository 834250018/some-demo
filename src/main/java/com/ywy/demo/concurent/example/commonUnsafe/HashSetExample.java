package com.ywy.demo.concurent.example.commonUnsafe;

import com.ywy.demo.concurent.annotations.ThreadNotSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author ve
 * @date 2020/3/12 19:19
 */
@ThreadNotSafe
@Slf4j
public class HashSetExample {

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发请求数
    public static int threadTotal = 200;

    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add(count);
                    semaphore.release();
                } catch (Exception e) {
                    log.info("error: " + e.getMessage());
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("{}:" + set.size());
    }

    private static void add(int i) throws ParseException {
        set.add(i);
    }
}
