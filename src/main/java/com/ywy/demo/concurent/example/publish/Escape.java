package com.ywy.demo.concurent.example.publish;

import com.ywy.demo.concurent.annotations.NotRecommend;
import com.ywy.demo.concurent.annotations.ThreadNotSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ve
 * @date 2020/3/12 21:27
 */
@ThreadNotSafe @NotRecommend @Slf4j public class Escape {
    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    public static void main(String[] args) {
        new Escape();
    }

    private class InnerClass {
        public InnerClass() {
            log.info("" + Escape.this.thisCanBeEscape);
        }
    }
}
