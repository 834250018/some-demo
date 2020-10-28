package cn.ve.algorithm.bubblesort;

/**
 * @author ve
 * @date 2020/10/1
 * @description
 */
public class Common {

    /**
     * 交换
     *
     * @param ints
     * @param i
     * @param j
     */
    public static void exchange(int[] ints, int i, int j) {
        int anInt = ints[i];
        ints[i] = ints[j];
        ints[j] = anInt;
    }

}
