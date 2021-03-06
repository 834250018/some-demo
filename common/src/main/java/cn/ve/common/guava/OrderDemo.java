package cn.ve.common.guava;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ve
 * @date 2020/3/2 13:27
 */
@Slf4j public class OrderDemo {
    public static void main(String[] args) {

        // Comparable类型的自然排序,整数从小到大,字符串字典顺序
        Ordering<String> naturalOrdering = Ordering.natural();
        // 使用toString返回的字符串按字典顺序
        Ordering<Object> toStringOrdering = Ordering.usingToString();
        //
        Ordering<Object> arbitraryOrdering = Ordering.arbitrary();

        Ordering<String> byLengthOrdering = new Ordering<String>() {
            @Override public int compare(@Nullable String left, @Nullable String right) {
                return Ints.compare(left.length(), right.length());
            }
        };
        List<String> list = Stream.of("a", "bbb", "cc").collect(Collectors.toList());
        log.info("naturalOrdering: " + naturalOrdering.sortedCopy(list)); // [a, bbb, cc]
        log.info("toStringOrdering: " + toStringOrdering.sortedCopy(list)); // [a, bbb, cc]
        log.info("arbitraryOrdering: " + arbitraryOrdering.sortedCopy(list)); // [bbb, a, cc]
        log.info("自定义比较器byLengthOrdering: " + byLengthOrdering.sortedCopy(list)); // [a, cc, bbb]

        // 似乎是某种hashCode排序
        List<String> list1 = Stream.of("a", "bb", "ccc", "dddd", "eeeee", "ff").collect(Collectors.toList());
        log.info("arbitraryOrdering: " + arbitraryOrdering.sortedCopy(list1)); // [bb, a, ccc, dddd, eeeee, ff]

        log.info("naturalOrdering.reverse: " + naturalOrdering.reverse().sortedCopy(list)); // [cc, bbb, a]

        // 空值前置
        List<String> list2 = Stream.of("a", "bb", null, "ccc", "dddd", "eeeee", "ff").collect(Collectors.toList());
        log.info("naturalOrdering.nullsFirst: " + naturalOrdering.nullsFirst()
            .sortedCopy(list2)); // [null, a, bb, ccc, dddd, eeeee, ff]

        // 先年龄,后名字
        Ordering<User> byNameAndAge = new Ordering<User>() {
            @Override public int compare(@Nullable User left, @Nullable User right) {
                return left.getAge() - right.getAge();
            }
        };
        List<User> users =
            Stream.of(new User(20, "欧阳娜娜"), new User(20, "张三"), new User(21, "aaaaaaa"), new User(21, "b"))
                .collect(Collectors.toList());
        // compound多级排序,类似于管道
        log.info("compound: " + byNameAndAge.compound(Comparator.comparing((User::getName))).sortedCopy(users));

        log.info("sortedCopy: " + byNameAndAge.sortedCopy(users)); // 返回排序中的所有元素
        log.info("greatestOf: " + byNameAndAge.greatestOf(users, 2)); // 返回排序中最大的2个元素
        log.info("leastOf: " + byNameAndAge.leastOf(users, 4)); // 返回排序中最小的4个元素

        log.info("onResultOf: " + Ordering.natural().onResultOf(User::getName)
            .sortedCopy(users)); // 依据对象里面的某个属性(如getName)进行自然排序

    }
}
