package com.ywy.demo.equals;

/**
 * @author ve
 * @date 2019/7/3 15:24
 */
public class IntegerTest {
    public static void main(String[] args) {
        int i1 = 100;
        int i2 = 100;
        System.out.println(i1 == i2); // true
        int i3 = 200;
        int i4 = 200;
        System.out.println(i3 == i4); // true
        Integer ii1 = 100;
        Integer ii2 = 100;
        System.out.println(ii1 == ii2); // true
        Integer ii3 = 200;
        Integer ii4 = 200;
        // 包装类超出-127~128的范围,会在堆种创建,所以地址不相同
        System.out.println(ii3 == ii4); // false

        System.out.println(ii3.equals(ii4)); // true
        System.out.println(ii3.intValue() == ii4.intValue()); // true
    }
}
