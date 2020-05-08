package cn.ve.design_pattern.creational_patterns.abstract_factory;

/**
 * 抽象工厂类,包含所有的产品族
 * 先理解产品族与产品等级结构这两个概念
 * 举个例子 美的 格力 海尔三个品牌均生产冰箱 洗衣机 空调
 * 功能相同或相近的为同一产品等级结构(美的冰箱,格力冰箱,海尔冰箱,三者为同一个产品等级结构)
 * 不同产品结构的一组为产品族(冰箱,洗衣机,空调,三者为一个产品族)
 * 产品族,人无我有.产品等级结构,人有我优.
 * 抽象工厂适用于产品等级结构经常扩展的场景,但是不适用于产品族的扩展
 * 如果产品族增加一个造飞机,则需要在每个品牌下都增加造飞机逻辑
 * 如果产品等级结构增加一个品牌,则只需要新增一个品牌工厂及对应的三个产品即可
 * @author ve
 * @date 2020/4/30 23:59
 */
public interface AbstractFactory {
    冰箱 生产冰箱();
    洗衣机 生产洗衣机();
    空调 生产空调();
}