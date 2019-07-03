package com.ywy.demo.pattern;

/**
 * 单例模式
 *
 * @author ve
 * @date 2019/6/19 15:34
 */
public class SingletonPatternDemo {

    // 必须私有的构造方法
    private SingletonPatternDemo() {
    }

    // 饿汉模式
    SingletonPatternDemo singletonDemo = new SingletonPatternDemo();

    public SingletonPatternDemo getInstance() {
        return singletonDemo;
    }

    // 懒汉模式
    SingletonPatternDemo singletonDemo1;

    public SingletonPatternDemo getInstance1() {
        if (singletonDemo1 == null) {
            singletonDemo1 = new SingletonPatternDemo();
        }
        return singletonDemo1;
    }

    // 单例枚举
    enum singletonEnumDemo{
        INSTANCE
    }

}