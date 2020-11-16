package com.ywy.demo.other;

/**
 * @author ve
 * @date 2019/7/3 17:16
 */
public class EnumTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override public void run() {
                CarTypeEnum.TYPE1.exec("测试1");
            }
        }).start();
        new Thread(new Runnable() {
            @Override public void run() {
                CarTypeEnum.TYPE1.exec("test2");
            }
        }).start();
    }
}
