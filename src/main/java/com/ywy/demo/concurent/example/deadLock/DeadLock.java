package com.ywy.demo.concurent.example.deadLock;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ve
 * @date 2020/3/13 22:41
 */
@Slf4j public class DeadLock implements Runnable {

    // 静态对象是类的所有对象共享的
    private static Object o1 = new Object(), o2 = new Object();
    public int flag = 1;

    public static void main(String[] args) {
        DeadLock dl1 = new DeadLock();
        DeadLock dl2 = new DeadLock();
        dl1.flag = 1;
        dl2.flag = 0;

        // dl1,dl2都处于可执行状态,但JVM线程调度先执行哪个线程是不确定的
        // dl2的run()可能再dl1的run()之前运行
        new Thread(dl1).start();
        new Thread(dl2).start();
    }

    @Override public void run() {
        log.info("flag:{}", flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
                synchronized (o2) {
                    log.info("这里打印不了:1");
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
                synchronized (o1) {
                    log.info("这里打印不了:0");
                }
            }
        }
    }
}
