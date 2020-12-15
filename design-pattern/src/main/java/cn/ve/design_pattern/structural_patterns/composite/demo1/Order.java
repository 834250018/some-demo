package cn.ve.design_pattern.structural_patterns.composite.demo1;


import java.util.ArrayList;
import java.util.List;

/**
 * 一个订单,用一个访问模式来控制写下的菜品
 *
 * @author 83425
 * @date 2020/12/15
 */
public class Order {
    private List<Node> nodes = new ArrayList<>();

    public void accept(MenuNode menuNode) {
        System.out.println(menuNode.getName() + "下单失败,不允许预定菜单");
    }

    public void accept(MenuItemNode menuItemNode) {
        nodes.add(menuItemNode);
        System.out.println(menuItemNode.getName() + "下单成功");
    }
}
