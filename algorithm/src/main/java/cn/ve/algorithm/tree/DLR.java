package cn.ve.algorithm.tree;

import java.util.Stack;

/**
 * @author ve
 * @date 2020/10/1
 * @motto 这火我不传了!!!
 * @description 树的前序遍历
 */
public class DLR {
    public static void main(String[] args) {
        // 生成一棵链式存储的树
        BinaryTreeElement root = BinaryTreeElement.generateBinaryTree();

        dlr(root);
        System.out.println();
        // 生成一棵数组存储的树
        String[] strings = BinaryTreeByArray.generateBinaryTree();
        dlr(strings, 0);
        dlrWithStack(strings);

    }

    private static void dlr(BinaryTreeElement root) {
        System.out.println(root.getData());
        if (root.getLeftElement() != null) {
            dlr(root.getLeftElement());
        }
        if (root.getRightElement() != null) {
            dlr(root.getRightElement());
        }
    }

    private static void dlr(String[] strings, int index) {
        if (index > strings.length - 1 || strings[index] == null) {
            return;
        }
        System.out.println(strings[index]);
        dlr(strings, 2 * index + 1);
        dlr(strings, 2 * index + 2);
    }

    /**
     * 用栈替代递归进行前序遍历
     *
     * @param strings
     */
    private static void dlrWithStack(String[] strings) {
        Stack<String> stack = new Stack<>();

    }
}
