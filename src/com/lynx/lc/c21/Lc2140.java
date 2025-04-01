package com.lynx.lc.c21;

/**
 * 2140. 解决智力问题
 *
 * @date 2025/04/01
 */
public class Lc2140 {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];
            int next = Math.min(questions[i][1] + i + 1, n);
            dp[i] = Math.max(dp[i], dp[next] + questions[i][0]);
        }
        return dp[0];
    }

    /**
     * 暴力递归版本.
     */
    private long f(int[][] questions, int i) {
        if (i >= questions.length) {
            return 0;
        }
        // 当前不做
        long p1 = f(questions, i + 1);
        // 当前做
        long p2 = f(questions, i + questions[i][1] + 1) + questions[i][0];
        return Math.max(p1, p2);
    }
}
