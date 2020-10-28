package cn.ve.algorithm.tree;

import java.util.Stack;

/**
 * @author ve
 * @date 2020/10/1
 * @description 树的后序遍历
 */
public class LRD {
    public static void main(String[] args) {
        // 生成一棵链式存储的树
        BinaryTreeElement root = BinaryTreeElement.generateBinaryTree();

        lrd(root);
        System.out.println("lrdWithStack");
        lrdWithStack(root);
        System.out.println("lrdWithStack1");
        lrdWithStack1(root);
        System.out.println();
        // 生成一棵数组存储的树
        String[] strings = BinaryTreeByArray.generateBinaryTree();
        lrd(strings, 0);
        System.out.println("lrdWithStack(数组)");
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
     * 用栈对链表结构二叉树进行后序遍历,使用一个标识符secound标记当前栈顶是否是第二次访问
     * 一直访问到左边最深的叶子节点,
     * 获取当前栈顶
     * 先不出栈,是否有右孩子
     * 有右孩子的情况,当前栈顶标记首次访问结束,右孩子入栈
     * 以右孩子为栈顶继续上述操作
     * 第二次访问当某一结点,视为已访问过右孩子,当前栈顶出栈,继续对后续栈顶做上述操作
     *
     * @param root
     */
    private static void lrdWithStack(BinaryTreeElement root) {
        Stack<BinaryTreeElement> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.getLeftElement();
            }
            if (!stack.isEmpty()) {
                BinaryTreeElement peek = stack.peek();
                if (peek.isSecound()) {
                    // 第二次访问(即已经处理了右孩子)
                    // 出栈并打印节点
                    System.out.println(stack.pop().getData());
                } else {
                    // 修改标识符
                    peek.setSecound(true);
                    // 首次访问,继续访问右孩子
                    root = peek.getRightElement();
                }
            }

        }
    }

    /**
     * 入栈顺序为 根->右->左
     * 比如
     * 1.当前是左节点,是否是叶子节点
     * 2.是叶子节点,出栈
     * 3.当前是右节点
     * 4.是叶子节点,出栈
     * 5.当前是根节点,不是叶子节点,但是上次出栈节点是子节点,所以出栈
     * 再比如
     * 1.当前是左节点,不是叶子节点
     * 2.依次入栈,右孩子入栈,左孩子入栈
     * 3.当前是栈顶右孩子,是叶子节点,走上一个例子的流程
     *
     * @param root
     */
    private static void lrdWithStack1(BinaryTreeElement root) {
        Stack<BinaryTreeElement> stack = new Stack<>();
        BinaryTreeElement pre = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeElement peek = stack.peek();
            if ((peek.getLeftElement() == null && peek.getRightElement() == null) || (pre != null && (
                pre == peek.getLeftElement() || pre == peek.getRightElement()))) {
                System.out.println(peek.getData());
                stack.pop();
                pre = peek;
            } else {
                if (peek.getRightElement() != null) {
                    stack.push(peek.getRightElement());
                }
                if (peek.getLeftElement() != null) {
                    stack.push(peek.getLeftElement());
                }
            }
        }
    }

    /**
     * 同上,二叉树存储结构为数组
     *
     * @param strings
     */
    private static void lrdWithStack(String[] strings) {
        Stack<Integer> stack = new Stack<>();
        Integer pre = null;
        stack.push(0);
        while (!stack.isEmpty()) {
            Integer peek = stack.peek();
            if ((2 * peek + 1 >= strings.length || (strings[2 * peek + 1] == null && strings[2 * peek + 2] == null))
                || (pre != null && (pre == 2 * peek + 1 || pre == 2 * peek + 2))) {
                System.out.println(strings[peek]);
                stack.pop();
                pre = peek;
            } else {
                if (2 * peek + 2 < strings.length && strings[2 * peek + 2] != null) {
                    stack.push(2 * peek + 2);
                }
                if (2 * peek + 1 < strings.length && strings[2 * peek + 1] != null) {
                    stack.push(2 * peek + 1);
                }
            }
        }
    }
}
