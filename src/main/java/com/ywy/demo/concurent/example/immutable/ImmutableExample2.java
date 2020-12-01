package com.ywy.demo.concurent.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.ywy.demo.concurent.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

/**
 * @author ve
 * @date 2020/3/12 22:28
 */
@ThreadSafe
@Slf4j
public class ImmutableExample2 {

    private static Map<Integer, Integer> map;

    static {
        map = Maps.newHashMap();
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
        //        map.put(5, 6); UnsupportedOperationException
    }

    public static void main(String[] args) {
        //        Collections.unmodifiableXXX
        // java
        Collections.unmodifiableCollection(new HashSet<>());
        // guava
        ImmutableList immutableMap = new ImmutableList.Builder<String>().add("ff").build();
        log.info("{}", immutableMap);
    }

}
