package com.ywy.demo;

/**
 * @author ve
 * @date 2019/6/19 23:20
 */
public class Test {
    public static void main(String[] args) {
        String str = "aaa";
        changeStr(str);
        System.out.println(str); // aaa
    }

    static void changeStr(String str) {
        str = "bbb";
    }
}
