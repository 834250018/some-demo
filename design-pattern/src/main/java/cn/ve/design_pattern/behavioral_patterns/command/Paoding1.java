package cn.ve.design_pattern.behavioral_patterns.command;

/**
 * @author ve
 * @date 2020/5/2 18:14
 */
public class Paoding1 implements Receiver {
    @Override
    public void action() {
        System.out.println("庖丁一号出菜: 梅菜扣肉");
    }
}
