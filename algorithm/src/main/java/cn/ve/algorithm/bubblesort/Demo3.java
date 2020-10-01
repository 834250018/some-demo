package cn.ve.algorithm.bubblesort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ve
 * @date 2020/10/1
 * @motto 这火我不传了!!!
 * @description 冒泡排序, 升序
 */
@Slf4j public class Demo3 {
    public static void main(String[] args) {
        int[] ints = new int[] {1, 4, 5, 62, 35, 52, 3, 44, 24};
        // 优化前
        Demo2.bubbleSort(ints);
        ints = new int[] {1, 4, 5, 62, 35, 52, 3, 44, 24};
        // 优化后
        bubbleSort(ints);
    }

    /**
     * 在demo2的基础上进行优化
     * 比如数组 4,2,3,1,5,6,7,8,9
     * 右边是有序的,且总比左边无序部分最大值大
     * 所有有序边界不再是内循环结束后+1,而是最后一次交换的左下标
     *
     * @param ints
     */
    public static void bubbleSort(int[] ints) {
        // 计算执行次数
        int count = 0;
        for (int border = ints.length - 1; border >= 0; ) {
            boolean isSort = true;
            int lastExtend = border;
            for (int j = 0; j < border; j++) {
                count++;
                if (ints[j] > ints[j + 1]) {
                    Common.exchange(ints, j, j + 1);
                    isSort = false;
                    lastExtend = j;
                }
            }
            if (isSort) {
                break;
            }
            border = lastExtend;
        }
        log.info("循环次数:{}次", count);
        log.info("结果:{}", ints);
    }
}
