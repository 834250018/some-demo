package cn.ve.algorithm.tree;

import lombok.Data;

import java.util.List;

/**
 * @author ve
 * @date 2020/10/1
 * @description 树结构, 一个节点下面有任意个子节点
 */
@Data public class TreeElement {
    private List<TreeElement> children;

}
