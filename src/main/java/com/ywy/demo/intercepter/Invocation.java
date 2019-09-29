package com.ywy.demo.intercepter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ve
 * @date 2019/9/29 17:53
 */
public class Invocation {
    private Object target;
    private Method method;
    private Object[] args;

    private Invocation nextInvocation;

    public void invoke() {
        if(nextInvocation != null) {
            nextInvocation.invoke();
        } else {
            try {
                method.invoke(target, args);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
