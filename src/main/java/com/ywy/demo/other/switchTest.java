package com.ywy.demo.other;

import java.util.Calendar;

/**
 * @author ve
 * @date 2019/7/3 22:17
 */
public class switchTest {
    public static void main(String[] args) {
        method(null); // NPE
    }

    public static void method(String param) {
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }
    }
}

