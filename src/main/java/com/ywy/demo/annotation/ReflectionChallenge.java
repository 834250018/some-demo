package com.ywy.demo.annotation;

import java.util.Arrays;

/**
 * @author ve
 * @date 2019/7/28 23:39
 */
public class ReflectionChallenge {
    public static void main(String[] args) {
        System.out.println(Jedi.class.getAnnotation(Table.class).name());

        Arrays.stream(Jedi.class.getDeclaredFields()).forEach(field -> {
            if ("name".equals(field.getName())) {
                System.out.println(field.getAnnotation(Column.class).name1());
            }
        });
    }

    @Table(name = "testClass")
    static class Jedi {

        @Column(name1 = "testField")
        private String name;

    }
}
