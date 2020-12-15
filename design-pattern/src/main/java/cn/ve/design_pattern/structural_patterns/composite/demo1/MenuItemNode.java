package cn.ve.design_pattern.structural_patterns.composite.demo1;


/**
 * @author 83425
 * @date 2020/12/15
 */
public class MenuItemNode extends Node {
    @Override
    protected void writeDown(Order order) {
        order.accept(this);
    }
}
