package cn.ve.algorithm.tree;

import lombok.Data;

/**
 * @author ve
 * @date 2020/10/1
 * @motto 这火我不传了!!!
 * @description 链式存储结构的二叉树, 一个节点下面有不大于2个节点
 * 以下面这个树为例子
 * a
 * ↙ ↘
 * b      c
 * ↙ ↘    ↙ ↘
 * d   e
 * 1,3,7,15
 */
@Data public class BinaryTreeElement {
    private String data;
    private BinaryTreeElement leftElement;
    private BinaryTreeElement rightElement;

    public BinaryTreeElement(String data) {
        this.data = data;
    }

    public static BinaryTreeElement generateBinaryTree() {
        BinaryTreeElement root = new BinaryTreeElement("a");
        BinaryTreeElement b = new BinaryTreeElement("b");
        BinaryTreeElement c = new BinaryTreeElement("c");
        BinaryTreeElement d = new BinaryTreeElement("d");
        BinaryTreeElement e = new BinaryTreeElement("e");
        root.setLeftElement(b);
        root.setRightElement(c);
        b.setRightElement(d);
        c.setLeftElement(e);
        return root;
    }
}
