package cn.ve.algorithm.tree;

/**
 * @author ve
 * @date 2020/10/1
 * @motto 这火我不传了!!!
 * @description 树的中序遍历
 */
public class RDL {
    public static void main(String[] args) {
        // 生成一棵链式存储的树
        BinaryTreeElement root = BinaryTreeElement.generateBinaryTree();

        rdl(root);
        System.out.println();
        // 生成一棵数组存储的树
        String[] strings = BinaryTreeByArray.generateBinaryTree();
        rdl(strings, 0);

    }

    private static void rdl(BinaryTreeElement root) {
        if (root.getLeftElement() != null) {
            rdl(root.getLeftElement());
        }
        if (root.getRightElement() != null) {
            rdl(root.getRightElement());
        }
        System.out.println(root.getData());
    }

    private static void rdl(String[] strings, int index) {
        if (index > strings.length - 1 || strings[index] == null) {
            return;
        }
        rdl(strings, 2 * index + 1);
        rdl(strings, 2 * index + 2);
        System.out.println(strings[index]);
    }
}
