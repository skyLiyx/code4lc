package lyx.lc.c7;

/**
 * 746.使用最小花费爬楼梯
 */
public class Lc0746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 2];
        // 初始化dp[n]和dp[n + 1]为0
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1],dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }
}
