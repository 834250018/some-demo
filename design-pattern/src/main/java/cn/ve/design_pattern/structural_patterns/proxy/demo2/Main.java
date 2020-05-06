package cn.ve.design_pattern.structural_patterns.proxy.demo2;

import java.lang.reflect.Proxy;

/**
 * @author ve
 * @date 2020/5/1 19:01
 */
public class Main {
    public static void main(String[] args) {

        Auction dynamicProxy = (Auction) Proxy.newProxyInstance(
                Auction.class.getClassLoader(),
                new Class[]{Auction.class},
                new DynamicProxy(new Human()));
        dynamicProxy.doSomething();
    }
}
