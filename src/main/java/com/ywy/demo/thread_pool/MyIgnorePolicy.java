package com.ywy.demo.thread_pool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ve
 * @date 2019/7/3 18:11
 */
public class MyIgnorePolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() + " rejected");
    }
}
