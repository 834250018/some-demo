package cn.ve.algorithm.bubblesort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ve
 * @date 2020/10/1
 * @motto 这火我不传了!!!
 * @description 鸡尾酒排序(双向冒泡排序 、 鸡尾酒搅拌排序 、 搅拌排序 、 涟漪排序 、 来回排序或快乐小时排序), 升序
 */
@Slf4j public class Demo4 {
    public static void main(String[] args) {
        int[] ints =
            new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 01, 2, 8, 7, 6, 5, 4, 9, 8, 7, 6, 5, 4,
                3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 0, 1, 2, 3,
                4, 5, 6, 7, 8, 9, 01, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        // 优化前
        long l = System.currentTimeMillis();
        Demo1.bubbleSort(ints);
        long l1 = System.currentTimeMillis();
        ints =
            new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 01, 2, 8, 7, 6, 5, 4, 9, 8, 7, 6, 5, 4,
                3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 0, 1, 2, 3,
                4, 5, 6, 7, 8, 9, 01, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        // 优化后
        long l2 = System.currentTimeMillis();
        Demo4.bubbleSort(ints);
        long l3 = System.currentTimeMillis();
        log.info("时间:{}::{}", l1 - l, l3 - l2);
    }

    /**
     * 在demo3的基础上进行优化
     * 冒泡排序会对数组前面部分的有序性进行跳过,比如(2,3,4,5,6,7,8,9,1),需要进行八轮外循环
     * 故此如果内循环是双向的话,能对前面部分的有序性进行优化即第一轮内循环如果是从右往左,只需一轮内循环
     *
     * @param ints
     */
    public static void bubbleSort(int[] ints) {
        // 计算执行次数
        int count = 0;
        for (int border = ints.length - 1, start = 0; border >= start; ) {
            boolean isSort = true;
            int rightBorder = border;
            if (border % 2 == 0) {
                for (int j = start; j < border; j++) {
                    count++;
                    if (ints[j] > ints[j + 1]) {
                        Common.exchange(ints, j, j + 1);
                        isSort = false;
                        rightBorder = j;
                    }
                }
                border = rightBorder;
            } else {
                int leftBorder = start;
                for (int j = border; j > start; j--) {
                    count++;
                    if (ints[j - 1] > ints[j]) {
                        Common.exchange(ints, j, j - 1);
                        isSort = false;
                        leftBorder = j;
                    }
                }
                start = leftBorder;
            }
            if (isSort) {
                break;
            }
        }
        log.info("循环次数:{}次", count);
        log.info("结果:{}", ints);
    }
}
