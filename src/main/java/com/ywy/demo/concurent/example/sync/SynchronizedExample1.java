package com.ywy.demo.concurent.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 修饰代码块跟方法的锁,仅作用于同一个对象,不同对象互相不影响
 *
 * @author ve
 * @date 2020/3/12 20:29
 */
public class SynchronizedExample1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();

        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });


        executorService.shutdown();


    }

    public void test1(int j) {
        // 修饰一个代码块
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("test1 {}" + j + "-" + i);
            }
        }
    }

    // synchronized不会继承到子类上,因为它不属于方法声明的一部分
    // 修饰方法
    public synchronized void test2(int j) {
        for (int i = 0; i < 100; i++) {
            System.out.println("test2 {}" + j + "-" + i);
        }
    }
}
