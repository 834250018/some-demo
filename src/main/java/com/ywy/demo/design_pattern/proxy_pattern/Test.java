package com.ywy.demo.design_pattern.proxy_pattern;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

/**
 * @author ve
 * @date 2019/7/11 13:35
 */
@Slf4j
public class Test {
    public static void main(String[] args) {

        Human human = new Human();
        log.info("-------直接吃饭(不走代理)------");
        human.doSomething();

        log.info("");
        StaticProxy proxy = new StaticProxy(new Human());
        proxy.doSomething();

        log.info("");
        Human human1 = new Human();
        Auction proxy1 = (Auction) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Auction.class}, new DynamicProxy(human1));
        proxy1.doSomething();
    }
}
