package com.lynx.lc.c8;

/**
 * 879. 盈利计划
 */
public class Lc0879 {
    private static final long MOD = (long)1e9 + 7;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int[][][] dp = new int[len][n + 1][minProfit + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < minProfit + 1; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return f(group, profit, 0, n, minProfit, dp);
    }

    private int f(int[] group, int[] profit, int i, int n, int minProfit, int[][][] dp) {
        if (i == group.length) {
            return minProfit == 0 ? 1 : 0;
        }
        if (n <= 0) {
            return minProfit == 0 ? 1 : 0;
        }
        if (dp[i][n][minProfit] != -1) {
            return dp[i][n][minProfit];
        }
        // 1.不做当前
        int p1 = f(group, profit, i + 1, n, minProfit, dp);
        // 2.做当前
        int p2 = 0;
        if (n >= group[i]) {
            p2 = f(group, profit, i + 1, n - group[i], Math.max(0, minProfit - profit[i]), dp);
        }
        dp[i][n][minProfit] = (int) (((long)p1 + p2) % MOD);
        return dp[i][n][minProfit];
    }
}
