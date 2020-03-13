package com.ywy.demo.concurent.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ve
 * @date 2020/3/12 20:29
 */
@Slf4j
public class SynchronizedExample3 {

    // 如果有static修饰,则是类锁,如果没有,则是对象锁
    private static byte[] bytes = new byte[0];

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        SynchronizedExample3 example1 = new SynchronizedExample3();
        SynchronizedExample3 example2 = new SynchronizedExample3();

        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });


        executorService.shutdown();


    }

    public void test1(int j) {
        // 修饰一个类
        synchronized (bytes) {
            for (int i = 0; i < 100; i++) {
                log.info("test1 {}" + j + "-" + i);
            }
        }
    }
}
