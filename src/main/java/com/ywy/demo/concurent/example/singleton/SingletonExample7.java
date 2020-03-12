package com.ywy.demo.concurent.example.singleton;

import com.ywy.demo.concurent.annotations.Recommend;
import com.ywy.demo.concurent.annotations.ThreadSafe;

/**
 * 枚举模式
 * 线程安全
 * @author ve
 * @date 2020/3/12 21:37
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {
    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }
    private enum Singleton {
        INSTANCE;
        private SingletonExample7 singleton;
        // JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }
        public SingletonExample7 getInstance() {
            return singleton;
        }
    }
}
