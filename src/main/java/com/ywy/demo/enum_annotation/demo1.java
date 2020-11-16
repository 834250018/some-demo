package com.ywy.demo.enum_annotation;

import java.io.IOException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.stream.Collectors;

/**
 * @author ve
 * @date 2020/5/15
 */
@TestException(RuntimeException.class) @TestException(IOException.class) public class demo1 {

    public static void main(String[] args) {

        Plant[] plants = {new Plant("ANNUAL", Plant.LifeCycle.ANNUAL), new Plant("BIENNIAL", Plant.LifeCycle.BIENNIAL)};

        System.out.println(Arrays.stream(plants).collect(Collectors.groupingBy(p -> p.lifeCycle)));

        System.out.println(Arrays.stream(plants).collect(
            Collectors.groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(Plant.LifeCycle.class), Collectors.toSet())));

        System.out.println(Phase.Transition.from(Phase.GAS, Phase.SOLID));

        // 注解不能找到TestException,而是找到它的容器TestExceptionContainer
        System.out.println(demo1.class.isAnnotationPresent(TestException.class)); // false
        System.out.println(demo1.class.isAnnotationPresent(TestExceptionContainer.class)); // true
        // 一般通过这种方式判断注解是否存在
        System.out.println(demo1.class.isAnnotationPresent(TestException.class) || demo1.class
            .isAnnotationPresent(TestExceptionContainer.class)); // true
    }
}
