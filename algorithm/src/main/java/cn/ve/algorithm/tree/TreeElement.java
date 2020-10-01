package cn.ve.algorithm.tree;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author ve
 * @date 2020/10/1
 * @motto 这火我不传了!!!
 * @description 树结构, 一个节点下面有任意个子节点
 */
@Data public class TreeElement {
    private List<TreeElement> children;

}
