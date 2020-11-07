package cn.ve.algorithm;

/**
 * 在一个int数组中,有两个不同的数字只存在一次,其他数字均存在两次,找出只存在一次的数字
 *
 * @author ve
 * @date 2020/11/7
 */
public class IntDemo1 {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 5, 5, 8, 8, 3, 3, 2, 2, 7, 7, 44, 66, 66, 6111, 55, 55, 33, 33,};
        // 计算出两个目标数字的异或结果
        int result1 = 0;
        for (int i : arr) {
            result1 ^= i;
        }
        // result1 的二进制中从右到左,找到第一位非零,可以把原数组分为两个数组,一个数组包含此位非零的目标数字,另一个数组包含此位为零的目标数字
        int i = 1;
        while ((result1 ^ i) == 0) {
            i = i << 1;
        }
        int result2 = 0, result3 = 0;
        for (int j : arr) {
            if ((j & i) == i) {
                result2 ^= j;
            } else {
                result3 ^= j;
            }
        }
        System.out.println(result2 + ":" + result3);
    }
}
