package com.ywy.demo;

/**
 * @author ve
 * @date 2020/4/21 15:31
 */
public class JMMTest {

    public final static int LEN1 = 1024*1024;
    public final static int LEN2 = 6;
    public static long[][] l1 = new long[LEN1][LEN2];
    public static long[][] l2 = new long[LEN1][LEN2];

    public static void main(String[] args) {
        for (int x = 0; x < 10; x++) { // 测试十次
            // 初始化
            for (int i = 0; i < l1.length; i++) {
                for (int j = 0; j < l1[i].length; j++) {
                    l1[i][j] = 1L;
                }
            }
            for (int i = 0; i < l1.length; i++) {
                for (int j = 0; j < l1[i].length; j++) {
                    l2[i][j] = 1L;
                }
            }

            int sum = 0;

            long begin = System.nanoTime();
            for (int i = 0; i < LEN1; i++) {
                for (int j = 0; j < LEN2; j++) {
                    sum += l1[i][j];
                }
            }

            long middle = System.nanoTime();
            sum = 0;
            long middle1 = System.nanoTime();
            for (int j = 0; j < LEN2; j++) {
                for (int i = 0; i < LEN1; i++) {
                    sum += l2[i][j];
                }
            }
            long end = System.nanoTime();
            System.out.println("比较:" + (middle - begin)/1000000 + " : " + (end - middle1)/1000000);
        }

    }
}
