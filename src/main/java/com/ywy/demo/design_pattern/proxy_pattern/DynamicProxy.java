package com.ywy.demo.design_pattern.proxy_pattern;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ve
 * @date 2019/7/11 13:19
 */
@Slf4j
public class DynamicProxy implements InvocationHandler {

    Object targetObj;

    public DynamicProxy(Object targetObj) {
        this.targetObj = targetObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("动态代理:");
        log.info("执行了一次代理,执行方法为:" + method.getName() + "执行对象:" + targetObj);
        return method.invoke(targetObj, args);
    }
}
