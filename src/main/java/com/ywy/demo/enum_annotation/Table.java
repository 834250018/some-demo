package com.ywy.demo.enum_annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author ve
 * @date 2019/7/28 23:39
 */
@Retention(RetentionPolicy.RUNTIME) public @interface Table {
    String name() default "";
}
