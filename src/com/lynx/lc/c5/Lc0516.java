package com.lynx.lc.c5;

/**
 * 516. 最长回文子序列
 *
 * @apiNote 动态规划
 */
public class Lc0516 {
    public int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] dp = new int[n];
        for (int l = n - 1, leftDown = 0, backup; l >= 0; l--) {
            dp[l] = 1;
            if (l + 1 < n) {
                leftDown = dp[l + 1];
                dp[l + 1] = c[l] == c[l + 1] ? 2 : 1;
            }
            for (int r = l + 2; r < n; r++) {
                backup = dp[r];
                if (c[l] == c[r]) {
                    dp[r] = leftDown + 2;
                } else {
                    dp[r] = Math.max(dp[r - 1], dp[r]);
                }
                leftDown = backup;
            }
        }
        return dp[n - 1];
    }
}
