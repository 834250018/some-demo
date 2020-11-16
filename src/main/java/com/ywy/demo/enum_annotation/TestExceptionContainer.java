package com.ywy.demo.enum_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ve
 * @date 2020/5/15
 */
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.TYPE) public @interface TestExceptionContainer {
    TestException[] value();
}
