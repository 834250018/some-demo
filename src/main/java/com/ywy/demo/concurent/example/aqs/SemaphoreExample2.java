package com.ywy.demo.concurent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author ve
 * @date 2020/3/13 14:39
 */
@Slf4j
public class SemaphoreExample2 {
    private final static int threadCount = 200;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire(3); // 一次性获取三个许可
                    test(threadNum);
                    semaphore.release(3); // 一次性释放三个许可
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
            });
        }
        exec.shutdown();
    }

    public static void test(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{}" + threadNum);
//        Thread.sleep(100);
    }

}
