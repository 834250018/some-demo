package cn.ve.algorithm;

/**
 * 一座城市,由n座房子围城一个环形,每座房子都有对应的价值,为了防止被发现,小偷不能连续偷两间房间,问小偷怎么偷价值最大
 *
 * @author ve
 * @date 2020/11/7
 */
public class ThiefDemo {
    public static void main(String[] args) {
        int[] arr = new int[] {0, 2, 5, 1, 3, 6, 4, 7, 8, 9}; // 27
        int steal = steal(arr);
        System.out.println(steal);
    }

    private static int steal(int[] arr) {
        // 分两种情况,偷第一间有收益的房子还是不偷第一间有价值的房子
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (i == arr.length - 1) {
                    return arr[i];
                }
                if (i == arr.length - 2) {
                    return Math.max(arr[i], arr[i + 1]);
                }
                int cur = arr[i];
                arr[i] = 0;

                int len = arr.length - i - 1;
                if (i == 0) {
                    len--;
                }
                int[] arr2 = new int[len];
                System.arraycopy(arr, i + 1, arr2, 0, len);

                return Math.max(cur + steal(arr2), steal(arr));
            }
        }
        return 0;
    }
}
