package com.ywy.demo.equals;

import java.math.BigDecimal;

/**
 * @author ve
 * @date 2019/7/3 15:40
 */
public class FloatTest {
    public static void main(String[] args) {
        float f1 = 1.0f - 0.9f;
        float f2 = 0.9f - 0.8f;
        System.out.println(f1 == f2); // false
        Float f3 = Float.valueOf(f1);
        Float f4 = Float.valueOf(f2);
        System.out.println(f3.equals(f4)); // false
        // 推荐比较方法1
        System.out.println(Math.abs(f1 - f2) < 1e-6f); // true
        // 推荐比较方法2,使用BigDecimal进行运算操作
        BigDecimal b1 = new BigDecimal("1.0");
        BigDecimal b2 = new BigDecimal("0.9");
        BigDecimal b3 = new BigDecimal("0.8");
        BigDecimal bf1 = b1.subtract(b2);
        BigDecimal bf2 = b2.subtract(b3);
        System.out.println(bf1.equals(bf2)); // true

    }
}
