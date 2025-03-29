package com.lynx.lc.c0;

/**
 * 87. 扰乱字符串
 */
public class Lc0087 {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        boolean[][][] dp = new boolean[n][n][n + 1];
        for (int l1 = 0; l1 < n; l1++) {
            for (int l2 = 0; l2 < n; l2++) {
                dp[l1][l2][1] = c1[l1] == c2[l2];
            }
        }
        for (int len = 2; len <= n; len++) {
            // 由递归调用情况构建边界条件
            for (int l1 = 0; l1 <= n - len; l1++) {
                for (int l2 = 0; l2 <= n - len; l2++) {
                    for (int k = 1; k < len; k++) {
                        // s1左边对s2左边，s1右边对s2右边
                        if (dp[l1][l2][k] && dp[l1 + k][l2 + k][len - k]) {
                            dp[l1][l2][len] = true;
                            break;
                        }
                    }
                    if (!dp[l1][l2][len]) {
                        // s1在i处分割，交错
                        for (int k = 1; k < len; k++) {
                            // s1左边对s2右边，s1右边对s2左边
                            if (dp[l1][l2 + len - k][k] && dp[l1 + k][l2][len - k]) {
                                dp[l1][l2][len] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }

    /**
     * 记忆化搜索版本。
     */
    public boolean isScramble1(String s1, String s2) {
        int n = s1.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][][] dp = new int[n][n][n + 1];
        return f(c1, c2, 0, 0, n, dp);
    }

    private boolean f(char[] c1, char[] c2, int l1, int l2, int len, int[][][] dp) {
        if (dp[l1][l2][len] != 0) {
            return dp[l1][l2][len] == 1;
        }
        if (len == 1) {
            dp[l1][l2][len] = c1[l1] == c2[l2] ? 1 : -1;
            return c1[l1] == c2[l2];
        }
        boolean ans = false;
        // s1在i处分割，不交错
        for (int k = 1; k < len; k++) {
            // s1左边对s2左边，s1右边对s2右边
            if (f(c1, c2, l1, l2, k, dp) && f(c1, c2, l1 + k, l2 + k, len - k, dp)) {
               ans = true;
               break;
            }
        }
        if (!ans) {
            // s1在i处分割，交错
            for (int k = 1; k < len; k++) {
                // s1左边对s2右边，s1右边对s2左边
                if (f(c1, c2, l1, l2 + len - k, k, dp) && f(c1, c2, l1 + k, l2, len - k, dp)) {
                    ans = true;
                    break;
                }
            }
        }
        dp[l1][l2][len] = ans ? 1 : -1;
        return ans;
    }
}
