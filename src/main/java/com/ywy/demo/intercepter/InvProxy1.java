package com.ywy.demo.intercepter;

import java.lang.reflect.Method;

/**
 * @author ve
 * @date 2019/9/29 18:06
 */
public class InvProxy1 extends InvProxy {

    public InvProxy1(Object targetObj) {
        super(targetObj);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行之前");
        Object obj = method.invoke(targetObj, args);
        System.out.println("执行之后");
        return obj;
    }
}
