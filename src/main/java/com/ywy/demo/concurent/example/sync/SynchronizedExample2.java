package com.ywy.demo.concurent.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 修饰类块跟静态方法的锁,作用于所有对象
 *
 * @author ve
 * @date 2020/3/12 20:29
 */
@Slf4j
public class SynchronizedExample2 {
    public static void test1(int j) {
        // 修饰一个类
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 100; i++) {
                log.info("test1 {}" + j + "-" + i);
            }
        }
    }

    // 修饰静态方法
    public static synchronized void test2(int j) {
        for (int i = 0; i < 100; i++) {
            log.info("test2 {}" + j + "-" + i);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();

        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });

        executorService.shutdown();

    }
}
