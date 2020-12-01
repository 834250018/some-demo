package com.ywy.demo.concurent.example.singleton;

import com.ywy.demo.concurent.annotations.ThreadSafe;

/**
 * 饿汉模式
 * 线程安全
 *
 * @author ve
 * @date 2020/3/12 21:37
 */
@ThreadSafe
public class SingletonExample2 {
    private static SingletonExample2 instance = new SingletonExample2();

    private SingletonExample2() {

    }

    public static SingletonExample2 getInstance() {
        return instance;
    }
}
