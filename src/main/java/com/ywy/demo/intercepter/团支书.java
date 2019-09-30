package com.ywy.demo.intercepter;

import java.lang.reflect.Method;

/**
 * @author ve
 * @date 2019/9/29 18:06
 */
public class 团支书 extends InvProxy {

    public 团支书(Object targetObj) {
        super(targetObj);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("团支书告知团员要交团费");
        Object obj = method.invoke(targetObj, args);
        System.out.println("团支书收到团员的团费"+args[0]+"元");
        System.out.println("团支书高高兴兴地整理所有团费,并上交");
        return obj;
    }
}
