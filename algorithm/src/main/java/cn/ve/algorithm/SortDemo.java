package cn.ve.algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * 插入排序
 *
 * @author ve
 * @date 2019/6/19 13:27
 */
@Slf4j
public class SortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 9, 2, 5, 4, 3, 6};
        quickSort(arr, 0, arr.length - 1);
        log.info("");
    }

    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[idx]) {
                    idx = j;
                }
            }
            if (idx != i) {
                arr[idx] = arr[idx] + arr[i];
                arr[i] = arr[idx] - arr[i];
                arr[idx] = arr[idx] - arr[i];
            }
        }
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] > arr[j - 1]) {
                    arr[j] = arr[j] + arr[j - 1];
                    arr[j - 1] = arr[j] - arr[j - 1];
                    arr[j] = arr[j] - arr[j - 1];
                }
            }
        }
    }

    /**
     * 快速排序
     * 例如  5, 7, 9, 2, 5, 4, 3, 6
     * index 0, 1, 2, 3, 4, 5, 6, 7 low=0,high=7,tmp = 5
     * 第一次,从high位开始找到比5大的6放入最低位 此时low=0,high=7
     * 结果 6, 7, 9, 2, 5, 4, 3, 6
     * 第二次,从最低位的第二位开始找比5小的2放最高位,此时low=3,high=7
     * 6, 7, 9, 2, 5, 4, 3, 2
     * 第三次,从右面开始找,没有找到大于5的数,把5放入占位的2中
     * 6, 7, 9, 5, 5, 4, 3, 2
     * 第一次排序结束,以5为中线,右边的数都大于5,右边的数都小于5
     * 然后递归排序左边的数组跟右边的数组
     */
    static int getMiddle(int[] arr, int low, int high) {
        int tmp = arr[low];
        while (low < high) {
            while (low < high && arr[high] <= tmp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] > tmp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = getMiddle(arr, low, high);  //将list数组进行一分为二
            quickSort(arr, low, middle - 1);        //对低字表进行递归排序
            quickSort(arr, middle + 1, high);       //对高字表进行递归排序
        }
    }

}
