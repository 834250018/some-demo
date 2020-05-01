package cn.ve.designpattern.creational_patterns.AbstractFactoryPattern;

/**
 * @author ve
 * @date 2020/5/1 13:00
 */
public class 美的工厂 implements AbstractFactory {
    public 冰箱 生产冰箱() {
        return new 美的冰箱();
    }

    public 洗衣机 生产洗衣机() {
        return new 美的洗衣机();
    }

    public 空调 生产空调() {
        return new 美的空调();
    }
}
