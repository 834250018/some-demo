package com.ywy.demo.design_pattern.proxy_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理模式
 * @author ve
 * @date 2019/7/11 13:17
 */
public class Human implements Auction {

    @Override
    public void doSomething() {
        System.out.println("人类在吃饭");
    }

    @Override
    public String toString() {
        return "执行Human.toString()";
    }
}
