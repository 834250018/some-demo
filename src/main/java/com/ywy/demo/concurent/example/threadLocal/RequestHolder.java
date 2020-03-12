package com.ywy.demo.concurent.example.threadLocal;

/**
 * @author ve
 * @date 2020/3/12 23:06
 */
public class RequestHolder {
    private final static ThreadLocal<Long> requestHolder = new InheritableThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }
    public static void remove() {
        requestHolder.remove();
    }
}
