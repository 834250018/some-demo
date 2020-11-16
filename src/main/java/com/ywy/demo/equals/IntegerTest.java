package com.ywy.demo.equals;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ve
 * @date 2019/7/3 15:24
 */
@Slf4j public class IntegerTest {
    public static void main(String[] args) {
        int i1 = 100;
        int i2 = 100;
        log.info("{}", i1 == i2); // true
        int i3 = 200;
        int i4 = 200;
        log.info("{}", i3 == i4); // true
        Integer ii1 = 100;
        Integer ii2 = 100;
        log.info("{}", ii1 == ii2); // true
        Integer ii3 = 200;
        Integer ii4 = 200;
        // 包装类超出-127~128的范围,会在堆种创建,所以地址不相同
        log.info("{}", ii3 == ii4); // false

        log.info("{}", ii3.equals(ii4)); // true
        log.info("{}", ii3.intValue() == ii4.intValue()); // true
    }
}
