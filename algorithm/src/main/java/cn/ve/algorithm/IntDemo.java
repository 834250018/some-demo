package cn.ve.algorithm;

/**
 * 在一个int数组中,只有一个数字只存在一次,其他数字均存在两次,找出只存在一次的数字
 *
 * @author ve
 * @date 2020/11/7
 */
public class IntDemo {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 5, 5, 8, 8, 3, 3, 2, 2, 7, 7, 44, 66, 66, 55, 55, 33, 33,};
        int result = 0;
        for (int i : arr) {
            result ^= i;
        }
        System.out.println(result);
    }
}
