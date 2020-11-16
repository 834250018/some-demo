package com.ywy.demo.concurent.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ve
 * @date 2020/3/13 16:59
 */
@Slf4j public class LockExample6 {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        new Thread(() -> {
            try {
                reentrantLock.lock();
                log.info("wait signal"); // 1
                condition.await(); // 执行了此行代码后,锁被释放,线程进入等待队列2
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("get signal"); // 5
            reentrantLock.unlock();
        }).start();

        new Thread(() -> {
            reentrantLock.lock();
            log.info("get lock"); // 2
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll(); // 执行了此行代码后,队列2中的线程进入到等待队列1,等待锁
            log.info("send signal ~");// 3
            reentrantLock.unlock(); // 4
        }).start();
    }
}
