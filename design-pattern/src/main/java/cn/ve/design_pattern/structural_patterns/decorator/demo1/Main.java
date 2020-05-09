package cn.ve.design_pattern.structural_patterns.decorator.demo1;

/**
 * 装饰器模式
 * 装饰器模式与代理模式类似,不过装饰器模式强调的是对被装饰对象的功能的增强,使用上还是原对象
 * 代理模式考虑的是屏蔽对被代理对象的直接访问,强调对被代理对象的控制
 *
 * @author ve
 * @date 2020/5/2 18:48
 */
public class Main {
    public static void main(String[] args) {
        Player player = new LOLPlayer();
        player.play(); // 直接玩
        机械键盘外设 decorator = new 机械键盘外设(player);
        player.play();
        decorator.playFast();
    }
}
