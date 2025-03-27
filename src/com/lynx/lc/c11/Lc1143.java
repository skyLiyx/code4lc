package com.lynx.lc.c11;

/**
 * 1143. 最长公共子序列
 *
 * @apiNote 动态规划
 */
public class Lc1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1, c2;
        if (text1.length() > text2.length()) {
            c1 = text1.toCharArray();
            c2 = text2.toCharArray();
        } else {
            c1 = text2.toCharArray();
            c2 = text1.toCharArray();
        }
        int m = c1.length; // 长
        int n = c2.length; // 短
        // dp[i][j]: text1前i个长度的子串和text2前j个长度的子串的最长公共子序列
        int[] dp = new int[n + 1];
        for (int len1 = 1; len1 <= m; len1++) {
            int leftUp = 0, backup;
            for (int len2 = 1; len2 <= n; len2++) {
                backup = dp[len2];
                if (c1[len1 - 1] == c2[len2 - 1]) {
                    dp[len2] = leftUp + 1;
                } else {
                    dp[len2] = Math.max(dp[len2], dp[len2 - 1]);
                }
                leftUp = backup;
            }
        }
        return dp[n];
    }
}
