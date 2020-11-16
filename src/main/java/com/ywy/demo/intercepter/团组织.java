package com.ywy.demo.intercepter;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @author ve
 * @date 2019/9/29 18:06
 */
@Slf4j public class 团组织 extends InvProxy {

    public 团组织(Object targetObj) {
        super(targetObj);
    }

    @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("团组织发布缴纳团费公告");
        Object obj = method.invoke(targetObj, args);
        log.info("团长开开心心地吃了顿海鲜大餐");
        return obj;
    }
}
