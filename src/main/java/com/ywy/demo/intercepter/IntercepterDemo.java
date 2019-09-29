package com.ywy.demo.intercepter;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author ve
 * @date 2019/9/29 18:02
 */
public class IntercepterDemo {

    public static void main(String[] args) {

        // 不使用代理
        new Student().study();
        System.out.println();

        // 使用代理,实现拦截器功能
        IStudent student = (IStudent) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{IStudent.class},
                new IntercepterProxy(new Student()));
        student.study();
    }


}
