package com.ywy.demo.thread_pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ve
 * @date 2019/7/3 18:11
 */
@Slf4j public class MyIgnorePolicy implements RejectedExecutionHandler {
    @Override public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        log.info(r.toString() + " rejected");
    }
}
