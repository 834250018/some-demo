package com.ywy.demo.design_pattern.proxy_pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ve
 * @date 2019/7/11 13:16
 */
@Slf4j
public class StaticProxy implements Auction {

    public Human human;

    public StaticProxy(Human human) {
        this.human = human;
    }

    @Override
    public void doSomething() {
        log.info("静态代理:人类在做饭");
        human.doSomething();
    }
}
