package com.ywy.demo.generic_type;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author ve
 * @date 2020/5/14
 */
public class Demo2 {

    public static void main(String[] args) {
        Object[] objects = pickTwo("xs", "ff", "gg");
        String[] strings = pickTwo("xs", "ff", "gg"); // ClassCastException
    }

    static <T> T[] toArray(T... args) { // 可变参数数组,编译器创建一个Object[]
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(b, c);
            default:
                return toArray(a, c);
        }
    }
}
