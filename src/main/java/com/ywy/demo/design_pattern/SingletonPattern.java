package com.ywy.demo.design_pattern;

/**
 * 单例模式
 *
 * @author ve
 * @date 2019/6/19 15:34
 */
public class SingletonPattern {

    // 饿汉模式
    SingletonPattern singletonDemo = new SingletonPattern();
    // 懒汉模式
    SingletonPattern singletonDemo1;

    // 必须私有的构造方法
    private SingletonPattern() {
    }

    public SingletonPattern getInstance() {
        return singletonDemo;
    }

    public SingletonPattern getInstance1() {
        if (singletonDemo1 == null) {
            singletonDemo1 = new SingletonPattern();
        }
        return singletonDemo1;
    }

    // 单例枚举
    enum singletonEnum {
        INSTANCE
    }

}