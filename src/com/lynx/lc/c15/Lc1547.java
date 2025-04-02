package com.lynx.lc.c15;

import java.util.Arrays;

/**
 * 1547. 切棍子的最小成本
 */
public class Lc1547 {
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        int[] nums = new int[len + 2];
        // nums[0] = 0;
        nums[len + 1] = n;
        Arrays.sort(cuts);
        System.arraycopy(cuts, 0, nums, 1, len);
        int[][] dp = new int[len + 2][len + 2];
        for (int i = 0; i < len + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i + 1] = 0;
        }
        for (int l = len - 1; l >= 0; l--) {
            for (int r = l + 2; r < len + 2; r++) {
                for (int i = l + 1; i < r; i++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][i] + (nums[r] - nums[l]) + dp[i][r]);
                }
            }
        }
        return dp[0][len + 1];
    }

    /**
     * 记忆化搜索递归版本. 在l~r范围内切割的最小成本.
     */
    private int f(int[] nums, int l, int r, int[][] dp) {
        if (l + 1 == r) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        int ans = Integer.MAX_VALUE;
        // 枚举切割点
        for (int i = l + 1; i < r; i++) {
            // 选择当前切割点的成本 = 切完后左边的成本 + 当前切割成本 + 切完后右边的成本
            ans = Math.min(ans, f(nums, l, i, dp) + (nums[r] - nums[l]) + f(nums, i, r, dp));
        }
        dp[l][r] = ans;
        return dp[l][r];
    }
}
