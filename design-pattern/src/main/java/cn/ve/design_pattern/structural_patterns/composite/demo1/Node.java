package cn.ve.design_pattern.structural_patterns.composite.demo1;

import java.util.List;

/**
 * 组合模式,类似于树的结构,不同的节点有共性跟差异,就好像树干跟树叶,功能不一样,但是都是树的一部分
 *
 * @author 83425
 * @date 2020/12/15
 */
public abstract class Node {

    /**
     * 所有节点都有自己的菜单[或菜品]名字
     */
    private String name;

    /**
     * 部分节点(即菜单)有子菜单(菜品)
     */
    private List<Node> childNode;

    /**
     * 只有菜品才能被预定,菜单不可以
     */
    protected abstract void writeDown(Order order);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<Node> childNode) {
        this.childNode = childNode;
    }
}
