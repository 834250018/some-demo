package com.ywy.demo.jvm;

import lombok.extern.slf4j.Slf4j;

/**
 * -Xss128k
 *
 * @author 83425
 * @date 2020/12/17
 */
@Slf4j
public class StackOverflowErrorDemo {

    static int deep = 0;// -Xss配置栈容量,栈容量越小,越早抛出异常,deep越小

    public static void main(String[] args) {
        try {
            justOverflow();
        } catch (Throwable t) {
            System.out.println("stack length:" + deep);
            throw t;
        }
    }

    private static void justOverflow() {
        deep++;
        justOverflow();
    }
}
