package com.ywy.demo.guava;

import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;

/**
 * @author ve
 * @date 2020/3/2 11:30
 */
public class NullDemo {
    public static void main(String[] args) {
        // 空值处理
        Optional<Integer> possible = Optional.of(5);
        possible.isPresent(); // return true
        possible.get(); // return 5

        Optional<Integer> possible1 = Optional.absent();
        System.out.println(possible1.isPresent());

        // 可空入参
        System.out.println(Optional.fromNullable(null).isPresent());
        // 不可空入参 NullPointerException
//        System.out.println(Optional.of(null));

        // 为空时返回默认值
        System.out.println(Optional.fromNullable(null).or("1"));

        Optional<String> optional = Optional.fromNullable(null);
        optional.asSet(); // return []
        Optional<String> optional1 = Optional.fromNullable("aa");
        optional1.asSet();// return ["aa"]

        MoreObjects.firstNonNull("a", "b"); // return "a"
        MoreObjects.firstNonNull(null, "b"); // return "b"
        MoreObjects.firstNonNull("a", null); // return "a"
//        MoreObjects.firstNonNull(null, null); // NullPointerException
        System.out.println();
    }
}
