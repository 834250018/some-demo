package cn.ve.algorithm.tree;

import java.util.Stack;

/**
 * @author ve
 * @date 2020/10/1
 * @description 树的前序遍历
 */
public class LDR {
    public static void main(String[] args) {
        // 生成一棵链式存储的树
        BinaryTreeElement root = BinaryTreeElement.generateBinaryTree();

        ldr(root);
        System.out.println();
        ldrWithStack(root);
        System.out.println();
        // 生成一棵数组存储的树
        String[] strings = BinaryTreeByArray.generateBinaryTree();
        ldr(strings, 0);
        System.out.println();
        ldrWithStack(strings);

    }

    private static void ldr(BinaryTreeElement root) {
        if (root == null) {
            return;
        }
        ldr(root.getLeftElement());
        System.out.println(root.getData());
        ldr(root.getRightElement());
    }

    private static void ldr(String[] strings, int index) {
        if (index > strings.length - 1 || strings[index] == null) {
            return;
        }
        ldr(strings, 2 * index + 1);
        System.out.println(strings[index]);
        ldr(strings, 2 * index + 2);
    }

    /**
     * 用栈替代递归进行前序遍历
     *
     * @param root
     */
    private static void ldrWithStack(BinaryTreeElement root) {
        Stack<BinaryTreeElement> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.getLeftElement();
            }
            if (!stack.isEmpty()) {
                BinaryTreeElement pop = stack.pop();
                System.out.println(pop.getData());
                root = pop.getRightElement();
            }

        }
    }

    /**
     * 用栈替代递归进行前序遍历
     *
     * @param strings
     */
    private static void ldrWithStack(String[] strings) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (strings[index] != null || !stack.isEmpty()) {
            while (index < strings.length && strings[index] != null) {
                stack.push(index);
                index = 2 * index + 1;
            }
            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                System.out.println(strings[pop]);
                index = 2 * pop + 2;
                if (index < strings.length) {
                    break;
                }
            }
        }
    }
}
