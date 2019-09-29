package com.ywy.demo.intercepter;

/**
 * @author ve
 * @date 2019/9/29 17:53
 */
public interface Interceptor {
    void intercept(Invocation inv);
}
