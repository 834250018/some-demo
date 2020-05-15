package com.ywy.demo.enum_annotation;

import java.lang.annotation.*;

/**
 * @author ve
 * @date 2020/5/15
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(TestExceptionContainer.class) // 可重入注解,需要一个容器进行存储
public @interface TestException {
    Class<? extends Exception> value();

    // 如果不使用可重入注解,则使用数组形式达到相同效果,推荐使用数组
//    Class<? extends Exception>[] value();
}