package cn.ve.design_pattern.structural_patterns.bridge.demo1;


/**
 * 桥接模式,一般我喝奶茶都是 少冰标准糖
 * 冰块数量变化,跟糖分比例变化,是两个独立变化的维度,如果把"少冰标准糖"作为一个类,就可能要写(n种冰块数量跟k种糖分比例的笛卡尔积)..很多类
 * 通过桥接模式分别维护两种变化,减少类的数量(n+k)
 *
 * @author 83425
 * @date 2020/12/15
 */
public class Main {
    public static void main(String[] args) {
        Ice ice = new Ice(1);
        Sugar sugar = new Sugar(5);

        // 简单演示,不同业务设计类跟代码逻辑不一样,会有很多变种
        new Milktea(ice, sugar).sale();

    }
}
