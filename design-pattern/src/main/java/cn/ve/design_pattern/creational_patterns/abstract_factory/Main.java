package cn.ve.design_pattern.creational_patterns.abstract_factory;

/**
 * 比如一开始有(格力海尔两个厂商生产冰箱空调洗衣机三种产品
 * 现在美的也加入进来,则创建一个美的工厂,还创建三个美的产品(冰箱空调洗衣机)
 * 对于客户来说,只需要去美的工厂即可买到美的下的产品,去美的工厂总不可能买到格力的产品吧?
 * 买到冰箱,不管是什么冰箱,都有冷藏的功能.
 *
 * @author ve
 * @date 2020/5/1 13:09
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new 格力工厂();// 通过工厂来确定产品等级结构
        冰箱 b = factory.生产冰箱();// 实际产品的等级结构对客户透明
        b.冷藏();
    }
}
