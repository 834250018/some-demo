package com.ywy.demo.concurent.example.publish;

import com.ywy.demo.concurent.annotations.ThreadNotSafe;

import java.util.Arrays;

/**
 * @author ve
 * @date 2020/3/12 21:24
 */
@ThreadNotSafe
public class UnsafePublish {
    private String[] states = {"a","b","c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        System.out.println("{}" + Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";
        System.out.println("{}" + Arrays.toString(unsafePublish.getStates()));
    }
}
