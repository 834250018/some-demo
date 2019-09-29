package com.ywy.demo.intercepter;

/**
 * @author ve
 * @date 2019/9/29 17:54
 */
public class IntercepterA implements Interceptor{

    @Override
    public void intercept(Invocation inv) {
        inv.invoke();
    }
}
