package com.ywy.demo.guava;

import com.google.common.base.Preconditions;

/**
 * @author ve
 * @date 2020/3/2 12:07
 */
public class PreconditionDemo {

    public static void main(String[] args) {
        // IllegalArgumentException: 前置条件为false,所以你能看到这段信息
//        Preconditions.checkArgument(false, "前置条件为false,所以你能看到这段信息");
        // return;
        Preconditions.checkArgument(true, "前置条件为false,所以你能看到这段信息");

        // IllegalArgumentException: i < j, i = 10, j = 20
        int i = 10;
        int j = 20;
//        Preconditions.checkArgument(i > j, "i < j, i = %s, j = %s", String.valueOf(i), String.valueOf(j));

        // NullPointerException
//        Preconditions.checkNotNull(null);

        // return ""
        Preconditions.checkNotNull("");

        Preconditions.checkElementIndex(i, j);
        // IndexOutOfBoundsException: index (20) must be less than size (10)
//        Preconditions.checkElementIndex(j, i);
    }

}
