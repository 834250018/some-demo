package cn.ve.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author ve
 * @date 2020/10/4
 * @motto 这火我不传了!!!
 * @description 层序遍历(广度优先搜索)
 */
public class BFS {
    public static void main(String[] args) {
        bfsWithQueue();
        System.out.println();
        bfsWithRecursion();
    }

    /**
     * 递归的方式实现层序遍历
     */
    private static void bfsWithRecursion() {
        BinaryTreeElement root = BinaryTreeElement.generateBinaryTree();
        // todo
    }

    /**
     * 数组的层序遍历
     */
    private static void bfsWithQueue(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println(arr[i]);
            }
        }
    }

    /**
     * 队列方式实现层序遍历
     */
    private static void bfsWithQueue() {
        BinaryTreeElement root = BinaryTreeElement.generateBinaryTree();

        Queue<BinaryTreeElement> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeElement poll = queue.poll();
            System.out.println(poll.getData());
            if (poll.getLeftElement() != null) {
                queue.offer(poll.getLeftElement());
            }
            if (poll.getRightElement() != null) {
                queue.offer(poll.getRightElement());
            }
        }
    }
}
