package cn.ve.common.guava;

import com.google.common.collect.LinkedHashMultiset;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ve
 * @date 2020/3/2 21:33
 */
@Slf4j
public class NewTypeCollectionDemo {
    public static void main(String[] args) {
        // 传统map计数
        Map<String, Integer> map = new HashMap<>();
        map.put("aa", 1);
        map.put("bb", 1);
        map.put("cc", 1);
        map.put("dd", 1);

        // Multiset 可以出现重复元素的set延伸,但不继承set,顺序无关性 {a,a,b}与{a,b,a}相等
        // 类似于无序的ArrayList
        // 类似于Map<E, Integer> 键为元素,值为计数
        LinkedHashMultiset<String> linkedHashMultiset = LinkedHashMultiset.create();
        linkedHashMultiset.add("dd");
        linkedHashMultiset.add("bb");
        linkedHashMultiset.add("dd");
        linkedHashMultiset.add("bb");
        log.info("{}", linkedHashMultiset.size());
        log.info("{}", linkedHashMultiset.count("bb"));
        // *Multiset
    }
}
