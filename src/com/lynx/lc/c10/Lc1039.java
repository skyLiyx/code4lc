package com.lynx.lc.c10;

/**
 * 1039. 多边形三角剖分的最低得分
 */
public class Lc1039 {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + 1 == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int l = n - 3; l >= 0; l--) {
            for (int r = l + 2; r < n; r++) {
                for (int i = l + 1; i < r; i++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][i] + dp[i][r] + values[l] * values[r] * values[i]);
                }
            }
        }
        return dp[0][n - 1];
    }

    /**
     * 记忆化搜索递归.
     */
    private int f(int[] nums, int l, int r, int[][] dp) {
        if (l == r || l + 1 == r) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        int ans = Integer.MAX_VALUE;
        // 枚举顶点
        for (int i = l + 1; i < r; i++) {
            // 以i为顶点的得分
            ans = Math.min(ans, f(nums, l, i, dp) + f(nums, i, r, dp) + nums[l] * nums[r] * nums[i]);
        }
        dp[l][r] = ans;
        return dp[l][r];
    }
}
