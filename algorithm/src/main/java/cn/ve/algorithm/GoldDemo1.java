package cn.ve.algorithm;

/**
 * 动态规范（图）
 * 假如有n座金矿，k个工人
 * 每座金矿要么不挖要么全挖(消耗固定个数的工人，收益固定数量的黄金)
 * 怎么才能达到最大收益？
 *
 * @author Administrator
 * @date 2020/10/28
 */
public class GoldDemo1 {

    // 金矿收益数组
    private static int[] g = new int[] {205, 677, 400, 666, 880};
    // 金矿需要工人数组
    private static int[] p = new int[] {6, 5, 3, 2, 4};

    public static void main(String[] args) {
        int[][] profit = new int[g.length][p.length];
        int maxProfit = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (p.length < p[j]) {
                    continue;
                }
                // 当前金矿不挖的收益是(人数不变，金矿挖上一座)
                int p1 = profit[i][j];
                // 当前金矿挖的收益是(人数减少，金矿挖上一座，再加上当前金矿)
                int p2 = profit[i][j - p[j]] + g[i];
                profit[i][j] = Math.max(p1, p2);
            }
        }
        System.out.println("最大收益是：" + maxProfit);

    }

}
