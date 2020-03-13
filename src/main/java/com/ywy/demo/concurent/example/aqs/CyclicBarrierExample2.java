package com.ywy.demo.concurent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author ve
 * @date 2020/3/13 16:06
 */
@Slf4j
public class CyclicBarrierExample2 {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000L);
            exec.execute(()->{
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
            });
        }
        exec.shutdown();
    }
    private static void race(int threadNum) throws Exception{
        Thread.sleep(1000L);
        log.info("{} is ready", threadNum);
        try  {
            cyclicBarrier.await(2, TimeUnit.SECONDS);
        }catch (BrokenBarrierException e) { // 等待超时后会抛出此异常
            log.error(e.getMessage());
        }
        log.info("{} continue", threadNum);
    }
}
