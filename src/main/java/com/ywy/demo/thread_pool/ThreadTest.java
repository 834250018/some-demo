package com.ywy.demo.thread_pool;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @author ve
 * @date 2019/7/3 17:27
 */
@Slf4j
public class ThreadTest {
    public static void main(String[] args) throws IOException {
        int corePoolSize = 2;
        int maximumPoolSize = 4;
        long keepAliveTime = 10L;
        TimeUnit unit = TimeUnit.SECONDS;
        // 有界队列,达到最大线程数后,队列有资源则等待,无则拒绝
        BlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(5);
        // 同步队列,有资源则执行,无资源则拒绝
        BlockingQueue<Runnable> synchronousQueue = new SynchronousQueue<>();
        // 无参构造无界/有参有界队列,只执行核心线程,其他所有线程进入队列等待
        BlockingQueue<Runnable> linkedBlockingDeque = new LinkedBlockingDeque<>();
        ThreadFactory threadFactory = new MyThreadFactory();
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, arrayBlockingQueue, threadFactory, handler);

        executor.prestartAllCoreThreads();
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("122222");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.in.read();

    }
}
