package com.lynx.lc.c6;

/**
 * 664. 奇怪的打印机
 */
public class Lc0664 {
    public int strangePrinter(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = arr[i] == arr[i + 1] ? 1 : 2;
        }
        dp[n - 1][n - 1] = 1;
        for (int l = n - 3; l >= 0; l--) {
            for (int r = l + 2; r < n; r++) {
                if (arr[l] == arr[r]) {
                    dp[l][r] = dp[l + 1][r];
                } else {
                    dp[l][r] = Integer.MAX_VALUE;
                    for (int i = l; i < r; i++) {
                        dp[l][r] = Math.min(dp[l][r], dp[l][i] + dp[i + 1][r]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    /**
     * 记忆化搜索递归版本.
     */
    private int f(char[] s, int l, int r, int[][] dp) {
        if (l == r) {
            return 1;
        }
        if (l + 1 == r) {
            return s[l] == s[r] ? 1 : 2;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        // 长度3及以上
        int p1 = Integer.MAX_VALUE;
        if (s[l] == s[r]) {
            p1 = f(s, l + 1, r, dp);
        }
        int p2 = Integer.MAX_VALUE;
        for (int i = l; i < r; i++) {
            p2 = Math.min(p2, f(s, l, i, dp) + f(s, i + 1, r, dp));
        }
        dp[l][r] = Math.min(p1, p2);
        return dp[l][r];
    }
}
