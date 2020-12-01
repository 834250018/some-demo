package com.ywy.demo.concurent.example.concurrent;

import com.ywy.demo.concurent.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.concurrent.*;

/**
 * 消耗内存,容易触发young-gc full-gc
 * 不能用于实时读,适合读多写少的场景
 * 写操作是先复制一份出来,然后再新数组上面进行修改,最后指向新数组
 * 读操作时直接读原数组
 *
 * @author ve
 * @date 2020/3/13 12:42
 */
@Slf4j
@ThreadSafe
public class CopyOnWriteArrayListExample {

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发请求数
    public static int threadTotal = 200;

    private static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.info("error: " + e.getMessage());
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("{}:" + list.size());
    }

    private static void add() throws ParseException {
        list.add(1);
    }
}
