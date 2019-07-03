package com.ywy.demo.equals;

import java.math.BigDecimal;

/**
 * @author ve
 * @date 2019/7/3 15:58
 */
public class DoubleTest {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal(0.1f);
        System.out.println(b1);// 0.100000001490116119384765625

        BigDecimal b4 = BigDecimal.valueOf(0.1f);
        System.out.println(b4);// 0.10000000149011612

        // 推荐使用valueOf
        BigDecimal b2 = BigDecimal.valueOf(0.1);
        System.out.println(b2);// 0.1

        BigDecimal b3 = BigDecimal.valueOf(0.1d);
        System.out.println(b3);// 0.1

        // 推荐使用字符串入参构造
        BigDecimal b5 = new BigDecimal("0.1");
        System.out.println(b5);// 0.1
    }
}
