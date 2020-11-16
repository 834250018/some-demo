package com.ywy.demo.concurent.example.singleton;

import com.ywy.demo.concurent.annotations.NotRecommend;
import com.ywy.demo.concurent.annotations.ThreadSafe;

/**
 * 懒汉模式
 * 线程安全
 *
 * @author ve
 * @date 2020/3/12 21:37
 */
@ThreadSafe @NotRecommend public class SingletonExample3 {
    private static SingletonExample3 instance = null;

    private SingletonExample3() {

    }

    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();// 多线程下有可能实例化两次
        }
        return instance;
    }
}
