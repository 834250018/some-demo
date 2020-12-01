package com.ywy.demo.concurent.example.publish;

import com.ywy.demo.concurent.annotations.ThreadNotSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author ve
 * @date 2020/3/12 21:24
 */
@ThreadNotSafe
@Slf4j
public class UnsafePublish {
    private String[] states = {"a", "b", "c"};

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}" + Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";
        log.info("{}" + Arrays.toString(unsafePublish.getStates()));
    }

    public String[] getStates() {
        return states;
    }
}
