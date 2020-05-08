package com.ywy.demo;

/**
 * 自动装箱带来的性能损耗
 * @author ve
 * @date 2020/5/8
 */
public class LongTest {
    private String a, b;

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
//        Long sum = 0L; // 使用Long,执行了近7s
        long sum = 0L; // 使用long,执行了近1s
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        System.out.println(sum);

    }
}
