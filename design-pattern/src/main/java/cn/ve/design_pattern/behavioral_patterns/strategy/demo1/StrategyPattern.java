package cn.ve.design_pattern.behavioral_patterns.strategy.demo1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 策略模式-枚举
 * 两个客户标签,一个是有钱人,一个是穷人,两个客户都放到一个集合
 * 通过遍历集合,所有的客户都执行枚举中的营销方法,实际执行的业务逻辑按类型自动选择
 *
 * @author ve
 * @date 2019/6/19 16:34
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Customer man1 = new Customer();
        Customer man2 = new Customer();
        man1.setType(CustomerTypeEnum.POOR);
        man2.setType(CustomerTypeEnum.RICH);
        List<Customer> collect = Stream.of(man1, man2).collect(Collectors.toList());

        // 通过策略模式做营销
        for (Customer customer : collect) {
            customer.getType().market();
        }
    }

}
