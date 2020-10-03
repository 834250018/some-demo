package cn.ve.algorithm.quicksort;

import cn.ve.algorithm.bubblesort.Common;
import lombok.extern.slf4j.Slf4j;

/**
 * 快速排序(单边循环法)
 *
 * @author ve
 * @date 2019/6/19 13:27
 */
@Slf4j public class QuickSort1 {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 7, 9, 2, 5, 4, 3, 6};
        quickSort(arr, 0, arr.length - 1);
        log.info("{}", arr);
    }

    /**
     * @param arr
     * @param lowIdx
     * @param highIdx
     */
    static void quickSort(int[] arr, int lowIdx, int highIdx) {
        if (highIdx <= lowIdx) {
            return;
        }
        int mark = lowIdx;
        for (int i = mark; i <= highIdx; i++) {
            if (arr[i] < arr[lowIdx]) {
                mark++;
                Common.exchange(arr, mark, i);
            }
        }
        Common.exchange(arr, mark, lowIdx);
        quickSort(arr, lowIdx, mark - 1);
        quickSort(arr, mark + 1, highIdx);
    }

}
