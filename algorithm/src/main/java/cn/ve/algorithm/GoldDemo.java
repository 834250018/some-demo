package cn.ve.algorithm;

/**
 * 动态规范(递归)
 * 假如有n座金矿，k个工人
 * 每座金矿要么不挖要么全挖(消耗固定个数的工人，收益固定数量的黄金)
 * 怎么才能达到最大收益？
 *
 * @author Administrator
 * @date 2020/10/28
 */
public class GoldDemo {

    // 金矿数量
    private static int n = 5;
    // 工人数量
    private static int k = 10;
    // 金矿收益数组
    private static int[] g = new int[]{205, 677, 400, 666, 880};
    // 金矿需要工人数组
    private static int[] p = new int[]{6, 5, 3, 2, 4};

    public static void main(String[] args) {
        // 递归法获得最大收益
        int maxProfit = getMaxProfit(n, k, g, p);
        System.out.println("最大收益是：" + maxProfit);

    }

    /**
     * 递归获取最大收益
     *
     * @param n 金矿数量
     * @param k 工人数量
     * @param g 金矿收益数组
     * @param p 对应金矿所需工人数量
     * @return
     */
    private static int getMaxProfit(int n, int k, int[] g, int[] p) {
        // 没有金矿或没有工人，返回收益0
        if (n <= 0 || k <= 0) {
            return 0;
        }
        // 分解问题，每个金矿要么挖，要么不挖，从最后一个金矿开始
        // 1.如果挖最后一个金矿,收益就是最后一个金矿挖了，加上递归其他金矿
        // 1.1.当前收益
        int curProfit = g[n - 1];
        // 1.2.其他金矿收益
        int otherProfit = getMaxProfit(n - 1, k - p[n - 1], g, p);
        // 2.如果没有挖最后一个金矿就直接排除最后一个金矿
        int excludeLastProfit = getMaxProfit(n - 1, k, g, p);
        // 上述1与2取最大收益返回
        return Math.max(curProfit + otherProfit, excludeLastProfit);
    }
}
