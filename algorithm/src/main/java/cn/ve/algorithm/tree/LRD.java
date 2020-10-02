package cn.ve.algorithm.tree;

import java.util.Stack;

/**
 * @author ve
 * @date 2020/10/1
 * @motto 这火我不传了!!!
 * @description 树的中序遍历
 */
public class LRD {
    public static void main(String[] args) {
        // 生成一棵链式存储的树
        BinaryTreeElement root = BinaryTreeElement.generateBinaryTree();

        lrd(root);
        System.out.println();
        lrdWithStack(root);
        System.out.println();
        // 生成一棵数组存储的树
        String[] strings = BinaryTreeByArray.generateBinaryTree();
        lrd(strings, 0);
        System.out.println();
        lrdWithStack(strings);

    }

    private static void lrd(BinaryTreeElement root) {
        if (root == null) {
            return;
        }
        lrd(root.getLeftElement());
        lrd(root.getRightElement());
        System.out.println(root.getData());
    }

    private static void lrd(String[] strings, int index) {
        if (index >= strings.length || strings[index] == null) {
            return;
        }
        lrd(strings, 2 * index + 1);
        lrd(strings, 2 * index + 2);
        System.out.println(strings[index]);
    }

    /**
     * 用栈替代递归进行前序遍历
     *
     * @param root
     */
    private static void lrdWithStack(BinaryTreeElement root) {// fixme
        Stack<BinaryTreeElement> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.getRightElement();
            }
            if (!stack.isEmpty()) {
                BinaryTreeElement pop = stack.pop();
                if (pop.getLeftElement() != null && pop.getLeftElement().getLeftElement() == null) {
                    System.out.println(pop.getLeftElement().getData());
                } else {
                    System.out.println(pop.getData());
                }
                root = pop.getLeftElement();
            }

        }
    }

    /**
     * 用栈替代递归进行前序遍历
     *
     * @param strings
     */
    private static void lrdWithStack(String[] strings) {// fixme
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
