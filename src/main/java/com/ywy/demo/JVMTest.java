package com.ywy.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author ve
 * @date 2020/4/19 16:58
 */
public class JVMTest {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        while (true) {
            for (int i = 0; i < 1000; i++) {
                list.add(new Properties());
            }
        }
    }
}
