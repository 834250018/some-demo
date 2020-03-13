package com.ywy.demo.intercepter;

import java.lang.reflect.InvocationHandler;

/**
 * @author ve
 * @date 2019/9/29 18:06
 */
public abstract class InvProxy implements InvocationHandler {

    Object targetObj;

    public InvProxy(Object targetObj) {
        this.targetObj = targetObj;
    }
}
