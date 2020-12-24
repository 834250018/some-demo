package com.ywy.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 83425
 * @date 2020/12/24
 */
@Slf4j
public class Test1 {
    public static void main(String[] args) {
        Integer i1 = 1;
        Integer i2 = 2;
        i2 = i1;
        i1 = 3;
        System.out.println(i1);
        System.out.println(i2);
    }
}
