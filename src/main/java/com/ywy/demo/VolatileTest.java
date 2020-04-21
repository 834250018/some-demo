package com.ywy.demo;

/**
 * volatile一种使用场景,确保静态变量的可见性
 * @author ve
 * @date 2020/4/21 15:31
 */
public class VolatileTest {

    public static volatile boolean flag = false;

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {

            }
            flag = true;
        }).start();
        while (!flag) {
        }
        System.out.println("使用volatile修饰flag就可以看到这行打印");

    }
}
