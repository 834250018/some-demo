package com.ywy.demo.concurent.example.singleton;

import com.ywy.demo.concurent.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉模式
 * 线程安全
 *
 * @author ve
 * @date 2020/3/12 21:37
 */
@Slf4j
@ThreadSafe
public class SingletonExample6 {
    private static SingletonExample6 instance = null; // 赋值操作会在静态域之后执行

    //    private static SingletonExample6 instance = null; // 这行代码放在这里是没有问题的
    static { // 静态域的顺序很重要
        instance = new SingletonExample6();
    }

    private SingletonExample6() {

    }

    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        log.info("" + getInstance().hashCode()); // NullPointerException
        log.info("" + getInstance().hashCode());
    }
}
