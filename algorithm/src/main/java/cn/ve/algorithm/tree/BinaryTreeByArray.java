package cn.ve.algorithm.tree;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author ve
 * @date 2020/10/1
 * @description 数组存储结构的二叉树
 * 某个节点下标为x ,则它的左子节点下标为 2x+1 , 右子节点下标为 2x+2
 * 深度为k ,最大节点数为2^k - 1
 * 以下面这个树为例子
 * a
 * ↙ ↘
 * b      c
 * ↙ ↘    ↙ ↘
 * d   e
 * 1,3,7,15
 */
@Slf4j @Data public class BinaryTreeByArray {

    public static void main(String[] args) {
        String[] treeArray = generateBinaryTree();

        // 打印数组
        log.info("二叉树的数组存储结构{}", Arrays.asList(treeArray));
    }

    public static String[] generateBinaryTree() {
        // 深度为3
        double k = 3d;
        // 最大数组长度为
        double size = Math.pow(2, k) - 1;
        // 初始化数组
        String[] treeArray = new String[(int)size];
        // 把 a,b,c,d,e放入树中
        treeArray[0] = "a";
        for (int i = 0; i < treeArray.length; i++) {
            if ("a".equals(treeArray[i])) {
                setChildren(treeArray, i, "b", "c");
            }
            if ("b".equals(treeArray[i])) {
                setChildren(treeArray, i, null, "d");
            }
            if ("c".equals(treeArray[i])) {
                setChildren(treeArray, i, "e", null);
            }
        }
        return treeArray;
    }

    /**
     * 根据当前下标给子节点赋值
     *
     * @param treeArray
     * @param index
     * @param left
     * @param right
     */
    private static void setChildren(String[] treeArray, int index, String left, String right) {
        treeArray[2 * index + 1] = left;
        treeArray[2 * index + 2] = right;
    }

}
