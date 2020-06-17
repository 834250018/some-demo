package com.ywy.demo.classloader;

/**
 * @author ve
 * @date 2020/5/22
 */
public class Demo2 {
    public static void main(String[] args) {
        Thread.currentThread().setContextClassLoader(new MyClassLoader());
    }
}
