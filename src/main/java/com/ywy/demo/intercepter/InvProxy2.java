package com.ywy.demo.intercepter;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @author ve
 * @date 2019/9/29 18:06
 */
@Slf4j
public class InvProxy2 extends InvProxy {

    public InvProxy2(Object targetObj) {
        super(targetObj);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("proxy2执行之前");
        Object obj = method.invoke(targetObj, args);
        log.info("proxy2执行之后");
        return obj;
    }
}
