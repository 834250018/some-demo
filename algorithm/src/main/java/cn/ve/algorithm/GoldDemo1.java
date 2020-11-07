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

    // 工人数量
    private static int k = 10;
    // 金矿收益数组
    private static int[] g = new int[] {205, 677, 400, 666, 880};
    // 金矿需要工人数组
    private static int[] p = new int[] {6, 5, 3, 2, 4};

    public static void main(String[] args) {
        // 初始化一个图 默认值为 0
        int[][] profit = new int[g.length + 1][k + 1];
        // 双层for循环计算"j个人挖前i座金矿能获取的最大收益,放入 profit[i][j]"
        for (int i = 1; i <= g.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (j < p[i - 1]) { // 如果人数不够挖前i-1座金矿,则最大收益就是前i-1座金矿的最大收益
                    profit[i][j] = profit[i - 1][j];
                } else { // 两种选择,要么挖第i座金矿,要么不挖
                    // 1.挖当前金矿的最大收益由两部分组成(1.当前金矿收益 2.剩下的人挖前i-1座金矿)
                    int profit1 = g[i - 1] + profit[i - 1][j - p[i - 1]];
                    // 2.不挖当前金矿,则获取前i-1座金矿的收益
                    int profit2 = profit[i - 1][j];
                    // 取最大值
                    profit[i][j] = Math.max(profit1, profit2);
                }
            }
        }
        System.out.println("最大收益是：" + profit[g.length][k]);

    }

}
