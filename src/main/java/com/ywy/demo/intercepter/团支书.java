package com.ywy.demo.intercepter;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @author ve
 * @date 2019/9/29 18:06
 */
@Slf4j public class 团支书 extends InvProxy {

    public 团支书(Object targetObj) {
        super(targetObj);
    }

    @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("团支书告知团员要交团费");
        Object obj = method.invoke(targetObj, args);
        log.info("团支书收到团员的团费" + args[0] + "元");
        log.info("团支书高高兴兴地整理所有团费,并上交");
        return obj;
    }
}
