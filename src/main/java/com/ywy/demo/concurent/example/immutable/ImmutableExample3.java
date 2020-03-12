package com.ywy.demo.concurent.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.ywy.demo.concurent.annotations.ThreadSafe;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author ve
 * @date 2020/3/12 22:28
 */
@ThreadSafe
public class ImmutableExample3 {

    private final static ImmutableList list = ImmutableList.of(1, 2, 3);
    private final static List list2 = ImmutableList.of(1, 2, 3);
    private final static ImmutableSet set = ImmutableSet.copyOf(list);
    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2);
    private final static Map<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder().put(1, 1).put(2, 2).build();

    public static void main(String[] args) {
        System.out.println(map2.get(2));
        Collections.emptyList().add(1); // UnsupportedOperationException
        list.add(4); // UnsupportedOperationException
        map.put(1, 1); // UnsupportedOperationException
    }

}
