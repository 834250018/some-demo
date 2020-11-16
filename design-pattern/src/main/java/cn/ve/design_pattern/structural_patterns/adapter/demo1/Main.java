package cn.ve.design_pattern.structural_patterns.adapter.demo1;

/**
 * 适配器模式,用于对已有接口的适配
 * 比如有一个插座,是三头的,但是国产ps4的电源插头是两头的,不能插入,此时需要一个适配器(转换器)
 * 这个例子有点片面,但是是最简单的,所以最适合用来理解
 * 很多框架中也用到了适配器模式,可以看demo了解代码层面的适配器模式
 *
 * @author ve
 * @date 2020/5/1 13:43
 */
public class Main {
    public static void main(String[] args) {
        ElectricSource electricSource = new ElectricSource();// 创建一个电源
        PS4 ps4 = new PS4(); // 创建一个两针插头的ps4
        //        electricSource.powerSupply(ps4); // 无法供电

        // 增加一个适配器
        ThreePinAdaptor threePinAdaptor = new ThreePinAdaptor();
        threePinAdaptor.powerSupply(ps4); // 适配器给ps4供电

        System.out.println("----------------");
        // 适配器先接入电源后给ps4供电
        electricSource.powerSupply(threePinAdaptor); // 电源给适配器供电
        threePinAdaptor.powerSupply(ps4); // 适配器给ps4供电
    }
}
