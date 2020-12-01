package com.ywy.demo.equals;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author ve
 * @date 2019/7/3 15:58
 */
@Slf4j
public class DoubleTest {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal(0.1f);
        log.info(b1.toString());// 0.100000001490116119384765625

        BigDecimal b4 = BigDecimal.valueOf(0.1f);
        log.info(b4.toString());// 0.10000000149011612

        // 推荐使用valueOf
        BigDecimal b2 = BigDecimal.valueOf(0.1);
        log.info(b2.toString());// 0.1

        BigDecimal b3 = BigDecimal.valueOf(0.1d);
        log.info(b3.toString());// 0.1

        // 推荐使用字符串入参构造
        BigDecimal b5 = new BigDecimal("0.1");
        log.info(b5.toString());// 0.1
    }
}
