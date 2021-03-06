package cn.ve.design_pattern.creational_patterns.abstract_factory;

/**
 * @author ve
 * @date 2020/5/1 13:00
 */
public class 海尔工厂 extends AbstractFactory {
    public 冰箱 生产冰箱() {
        return new 海尔冰箱();
    }

    public 洗衣机 生产洗衣机() {
        return new 海尔洗衣机();
    }

    public 空调 生产空调() {
        return new 海尔空调();
    }
}
