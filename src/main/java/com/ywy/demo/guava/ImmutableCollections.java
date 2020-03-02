package com.ywy.demo.guava;

import com.google.common.collect.*;

/**
 * 不可变集合,拒绝任何修改,安全,高效,空间,时间
 *
 * @author ve
 * @date 2020/3/2 21:17
 */
public class ImmutableCollections {
    public static void main(String[] args) {
        System.out.println();
        ImmutableList.of("abc");
        ImmutableSet.of("abc");
        ImmutableSortedSet.of("abc");
        ImmutableMap.of("key1", new User(21, "ff"));
        ImmutableMultiset.of("abc");
        ImmutableList immutableList = ImmutableList.of("abc");
        ImmutableList.copyOf(immutableList);
    }

}
