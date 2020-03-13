package com.ywy.demo.design_pattern.proxy_pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * 动态代理模式
 *
 * @author ve
 * @date 2019/7/11 13:17
 */
@Slf4j
public class Human implements Auction {

    @Override
    public void doSomething() {
        log.info("人类在吃饭");
    }

    @Override
    public String toString() {
        return "执行Human.toString()";
    }
}
