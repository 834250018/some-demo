package cn.ve.algorithm.bubblesort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ve
 * @date 2020/10/1
 * @motto 这火我不传了!!!
 * @description 冒泡排序, 升序
 */
@Slf4j public class Demo2 {
    public static void main(String[] args) {
        int[] ints = new int[] {1, 2, 3, 4, 5, 6, 7, 9, 8};
        // 优化前
        Demo1.bubbleSort(ints);
        ints = new int[] {1, 2, 3, 4, 5, 6, 7, 9, 8};
        // 优化后
        bubbleSort(ints);
    }

    /**
     * 在demo1的基础上进行优化
     * 比如数组 1,2,3,4,5,6,7,9,8
     * 第一轮内循环就完成了整个数组的排序,但是还是会继续执行外循环
     *
     * @param ints
     */
    public static void bubbleSort(int[] ints) {
        // 计算执行次数
        int count = 0;
        for (int border = ints.length - 1; border >= 0; border--) {
            boolean isSort = true;
            for (int j = 0; j < border; j++) {
                count++;
                if (ints[j] > ints[j + 1]) {
                    Common.exchange(ints, j, j + 1);
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
        log.info("循环次数:{}次", count);
        log.info("结果:{}", ints);
    }
}
