package cn.ve.common.guava;

import com.google.common.collect.*;
import lombok.extern.slf4j.Slf4j;

/**
 * 不可变集合,拒绝任何修改,安全,高效,空间,时间
 *
 * @author ve
 * @date 2020/3/2 21:17
 */
@Slf4j public class ImmutableCollections {
    public static void main(String[] args) {
        log.info("");
        ImmutableList.of("abc");
        ImmutableSet.of("abc");
        ImmutableSortedSet.of("abc");
        ImmutableMap.of("key1", new User(21, "ff"));
        ImmutableMultiset.of("abc");
        ImmutableList immutableList = ImmutableList.of("abc");
        ImmutableList.copyOf(immutableList);
    }

}
