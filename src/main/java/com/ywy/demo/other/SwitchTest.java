package com.ywy.demo.other;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ve
 * @date 2019/7/3 22:17
 */
@Slf4j public class SwitchTest {
    public static void main(String[] args) {
        method(null); // NPE
    }

    public static void method(String param) {
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                log.info("it's sth");
                break;
            // 也不是进入这里
            case "null":
                log.info("it's null");
                break;
            // 也不是进入这里
            default:
                log.info("default");
        }
    }
}

