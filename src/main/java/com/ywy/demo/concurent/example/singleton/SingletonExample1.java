package com.ywy.demo.concurent.example.singleton;

import com.ywy.demo.concurent.annotations.ThreadNotSafe;

/**
 * 懒汉模式
 * 线程不安全
 *
 * @author ve
 * @date 2020/3/12 21:37
 */
@ThreadNotSafe public class SingletonExample1 {
    private static SingletonExample1 instance = null;

    private SingletonExample1() {

    }

    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();// 多线程下有可能实例化两次
        }
        return instance;
    }
}
