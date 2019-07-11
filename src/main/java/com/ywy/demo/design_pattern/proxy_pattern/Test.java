package com.ywy.demo.design_pattern.proxy_pattern;

import java.lang.reflect.Proxy;

/**
 * @author ve
 * @date 2019/7/11 13:35
 */
public class Test {
    public static void main(String[] args) {

        Human human = new Human();
        System.out.println("-------直接吃饭(不走代理)------");
        human.doSomething();

        System.out.println("");
        StaticProxy proxy = new StaticProxy(new Human());
        proxy.doSomething();

        System.out.println("");
        Human human1 = new Human();
        Auction proxy1 = (Auction) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Auction.class}, new DynamicProxy(human1));
        proxy1.doSomething();
    }
}
