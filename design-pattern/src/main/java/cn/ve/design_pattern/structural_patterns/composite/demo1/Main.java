package cn.ve.design_pattern.structural_patterns.composite.demo1;


import java.util.ArrayList;

/**
 * @author 83425
 * @date 2020/12/15
 */
public class Main {
    public static void main(String[] args) {
        Node menu = new MenuNode();
        menu.setName("饮品");

        Node milk = new MenuItemNode();
        milk.setName("牛奶");

        menu.setChildNode(new ArrayList<>());
        menu.getChildNode().add(milk);

        // 创建一个订单
        Order order = new Order();
        menu.writeDown(order);
        milk.writeDown(order);
    }
}
