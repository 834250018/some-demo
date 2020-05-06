package cn.ve.design_pattern.structural_patterns.facade;

/**
 * 门面模式(外观模式)
 * 这里提一下模板模式,初见时感觉有点相似
 * 模板模式只维护总体的流程,不实现细节,而门面模式是把各部分都实现并对外提供唯一的入口
 * 这里举的例子是我们下班回家后要做的事情
 * 回到家要1.开门2.开电灯3.开热水器
 *
 * @author ve
 * @date 2020/5/6
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("--------不使用门面模式的情况下--------");
        Door door = new Door();
        Light light = new Light();
        Heater heater = new Heater();
        door.open();
        light.open();
        heater.open();
        System.out.println("\r\n--------使用门面模式-------------");
        // 如果使用门面模式
        Facade facade = new Facade();
        facade.open(); // 一个入口,一步到位

    }
}
