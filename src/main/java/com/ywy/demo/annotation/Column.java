package com.ywy.demo.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author ve
 * @date 2019/7/28 23:39
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String name1() default "";
}
