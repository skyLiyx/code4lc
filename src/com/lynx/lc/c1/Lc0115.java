package com.lynx.lc.c1;

/**
 * 115. 不同的子序列
 */
public class Lc0115 {
    public int numDistinct(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int m = c1.length;
        int n = c2.length;
        // dp[i][j]: s的前i个长度前缀中有多少个等于t的前j个长度的前缀
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j > 0; j--) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n];
    }
}
