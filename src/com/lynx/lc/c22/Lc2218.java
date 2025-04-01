package com.lynx.lc.c22;

import java.util.List;

/**
 * 2218. 从栈中取出 K 个硬币的最大面值和
 *
 * @apiNote 分组背包
 */
public class Lc2218 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int m = piles.size(); // 组的数量
        // dp[i][j]: 在前面 i 组中拿 j 次的最大收益
        int[] dp = new int[k + 1];
        for (int i = 1; i <= m; i++) {
            List<Integer> pile = piles.get(i - 1);
            int n = Math.min(k, pile.size()); // 当前组实际能拿的次数
            int[] preSum = new int[n + 1];
            for (int l = 0; l < n; l++) {
                preSum[l + 1] = preSum[l] + pile.get(l);
            }
            for (int j = k; j >= 0; j--) {
                // 当前组一个也不拿
                // dp[i][j] = dp[i - 1][j];
                // 当前组分别拿多次
                for (int l = 1; l <= n; l++) {
                    if (j - l >= 0) {
                        dp[j] = Math.max(dp[j], dp[j - l] + preSum[l]);
                    }
                }
            }
        }
        return dp[k];
    }
}
