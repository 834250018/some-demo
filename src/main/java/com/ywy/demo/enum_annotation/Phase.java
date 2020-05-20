package com.ywy.demo.enum_annotation;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ve
 * @date 2020/5/15
 */
public enum Phase {

    SOLID, LIQUID, GAS;

    public enum Transition {

        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        // Initialize hte phase transition map
        private static final Map<Phase, Map<Phase, Transition>>
                m = Stream.of(values()).collect(Collectors.groupingBy(
                t -> t.from, // 通过from分组,当前分三组
                () -> new EnumMap<>(Phase.class), // 创建一个EnumMap,key为分组条件,value为下一个参数处理的内容
                Collectors.toMap( // 下游收集器,比如SOLID组中,收集的初始内容为MELT跟SUBLIME,这里是把它转成map
                        t -> t.to,// map的键
                        t -> t, // map的值
                        (x, y) -> y,  // 当出现重复key时,使用后面插入的value
                        () -> new EnumMap<>(Phase.class) // 返回一个空映射,收集到的结果会插入其中
                )));

        public static Transition from(Phase from, Phase to) {
            return m.get(from).get(to);
        }
    }

}
