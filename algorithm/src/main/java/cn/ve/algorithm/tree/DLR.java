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
        dlrWithStack(root);
        System.out.println();
        // 生成一棵数组存储的树
        String[] strings = BinaryTreeByArray.generateBinaryTree();
        dlr(strings, 0);
        System.out.println();
        dlrWithStack(strings);

    }

    private static void dlr(BinaryTreeElement root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getData());
        dlr(root.getLeftElement());
        dlr(root.getRightElement());
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
     * @param root
     */
    private static void dlrWithStack(BinaryTreeElement root) {
        Stack<BinaryTreeElement> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.println(root.getData());
                stack.push(root);
                root = root.getLeftElement();
            }
            if (!stack.isEmpty()) {
                BinaryTreeElement pop = stack.pop();
                root = pop.getRightElement();
            }

        }
    }

    /**
     * 用栈替代递归进行前序遍历
     *
     * @param strings
     */
    private static void dlrWithStack(String[] strings) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (strings[index] != null || !stack.isEmpty()) {
            while (index < strings.length && strings[index] != null) {
                stack.push(index);
                System.out.println(strings[index]);
                index = 2 * index + 1;
            }
            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                index = 2 * pop + 2;
                if (index < strings.length) {
                    break;
                }
            }
        }
    }
}
