package com.ywy.demo.concurent.example.publish;

import com.ywy.demo.concurent.annotations.NotRecommend;
import com.ywy.demo.concurent.annotations.NotRecommend;
import com.ywy.demo.concurent.annotations.ThreadNotSafe;

/**
 * @author ve
 * @date 2020/3/12 21:27
 */
@ThreadNotSafe
@NotRecommend
public class Escape {
    private int thisCanBeEscape = 0 ;
    public Escape() {
        new InnerClass();
    }
    private class InnerClass {
        public InnerClass() {
            System.out.println(Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
