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
public class SemaphoreExample3 {
    private final static int threadCount = 200;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    //                    semaphore.tryAcquire(3);// 尝试获取3个许可
                    //                    semaphore.tryAcquire(2, TimeUnit.SECONDS);// 尝试获取1个许可,最长等待2秒
                    //                    semaphore.tryAcquire(3,2, TimeUnit.SECONDS);// 尝试获取3个许可,最长等待2秒
                    if (semaphore.tryAcquire()) { // 尝试获取许可
                        test(threadNum);
                        semaphore.release(); // 释放一个许可
                    } else {
                        // 没有获取到许可的,直接放弃,不做任何代码
                    }
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
