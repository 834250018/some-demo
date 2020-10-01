package cn.ve.algorithm.bubblesort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ve
 * @date 2020/10/1
 * @motto 这火我不传了!!!
 * @description 冒泡排序, 升序
 */
@Slf4j public class Demo1 {
    public static void main(String[] args) {
        int[] ints = new int[] {1, 2, 3, 4, 5, 6, 7, 9, 8};
        bubbleSort(ints);
    }

    /**
     * 最简单的冒泡 时间复杂度 O(n²)
     *
     * @param ints
     */
    public static void bubbleSort(int[] ints) {
        // 计算执行次数
        int count = 0;
        for (int border = ints.length - 1; border >= 0; border--) {
            for (int j = 0; j < border; j++) {
                count++;
                if (ints[j] > ints[j + 1]) {
                    Common.exchange(ints, j, j + 1);
                }
            }
        }
        log.info("循环次数:{}次", count);
        log.info("结果:{}", ints);
    }
}
