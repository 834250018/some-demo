package com.ywy.demo.other;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ve
 * @date 2019/9/23 11:30
 */
@Slf4j
public class StreamTest {
    public static void main(String[] args) {
        // 原数组(可以扩展为对象数组中的所有对象的某个字段)
        List<String> list =
                Stream.of("dfdsfjs", "uittyut", "nbvnvn", "gfhfghfg", "qweqeq").collect(Collectors.toList());
        // 排序规则,按这个列表的字符串顺序排序
        List<String> sortList =
                Stream.of("uittyut", "qweqeq", "dfdsfjs", "gfhfghfg", "nbvnvn").collect(Collectors.toList());
        // 权重排序
        List<String> result = list.stream()
                // 即.sorted((o1, o2) -> sortList.indexOf(o1) - sortList.indexOf(o2))
                .sorted(Comparator.comparingInt(sortList::indexOf)).collect(Collectors.toList());
        log.info(result.toString());
    }
}
