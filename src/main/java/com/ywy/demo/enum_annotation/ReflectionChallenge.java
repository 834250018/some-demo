package com.ywy.demo.enum_annotation;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author ve
 * @date 2019/7/28 23:39
 */
@Slf4j
public class ReflectionChallenge {
    public static void main(String[] args) {
        log.info(Jedi.class.getAnnotation(Table.class).name());

        Arrays.stream(Jedi.class.getDeclaredFields()).forEach(field -> {
            if ("name".equals(field.getName())) {
                log.info(field.getAnnotation(Column.class).name1());
            }
        });
    }

    @Table(name = "testClass")
    static class Jedi {

        @Column(name1 = "testField")
        private String name;

    }
}
