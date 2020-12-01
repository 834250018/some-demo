package com.ywy.demo.concurent.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标记线程不安全的注解
 *
 * @author ve
 * @date 2020/3/3 0:13
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadNotSafe {

    String value() default "";
}
