package cn.ve.algorithm.tree;

/**
 * @author ve
 * @date 2020/10/1
 * @motto 这火我不传了!!!
 * @description 树的中序遍历
 */
public class LDR {
    public static void main(String[] args) {
        // 生成一棵链式存储的树
        BinaryTreeElement root = BinaryTreeElement.generateBinaryTree();

        ldr(root);
        System.out.println();
        // 生成一棵数组存储的树
        String[] strings = BinaryTreeByArray.generateBinaryTree();
        ldr(strings, 0);

    }

    private static void ldr(BinaryTreeElement root) {
        if (root.getLeftElement() != null) {
            ldr(root.getLeftElement());
        }
        System.out.println(root.getData());
        if (root.getRightElement() != null) {
            ldr(root.getRightElement());
        }
    }

    private static void ldr(String[] strings, int index) {
        if (index > strings.length - 1 || strings[index] == null) {
            return;
        }
        ldr(strings, 2 * index + 1);
        System.out.println(strings[index]);
        ldr(strings, 2 * index + 2);
    }
}
