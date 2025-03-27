package com.lynx.lc.c4;

/**
 * 474. 一和零
 */
public class Lc0474 {
    private static int zeros, ones;

    /**
     * 空间压缩最终版本
     */
    public int findMaxForm(String[] strs, int m, int n) {
        // 代表 i = len
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            // 每来一个字符串，更新这一层的dp表
            // 默认dp[z][o](当前层) = dp[z][o](上一层)
            countZerosAndOnes(s);
            // 大的依赖上一层中小的，倒序
            // z >= zeros且o >= ones时才会更新第二种可能性，否则只依赖上一层，不更新
            for (int z = m; z >= zeros; z--) {
                for (int o = n; o >= ones; o--) {
                    dp[z][o] = Math.max(dp[z][o], 1 + dp[z - zeros][o - ones]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 三维动态规划
     */
    public int findMaxForm1(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len][m + 1][n + 1];
        for (int i = len - 1; i >= 0; i--) {
            for (int z = 0; z <= m; z++) {
                for (int o = 0; o <= n; o++) {
                    dp[i][z][o] = dp[i + 1][z][o];
                    countZerosAndOnes(strs[i]);
                    if (z >= zeros && o >= ones) {
                        dp[i][z][o] = Math.max(dp[i][z][o], 1 + dp[i + 1][z - zeros][o - ones]);
                    }
                }
            }
        }
        return dp[0][m][n];
    }

    /**
     * 递归+记忆化搜索版本。
     */
    public int findMaxForm2(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len][m + 1][n + 1];
        for (int i = 0; i < len; i++) {
            for (int z = 0; z <= m; z++) {
                for (int o = 0; o <= n; o++) {
                    dp[i][z][o] = -1;
                }
            }
        }
        return f(strs, 0, m, n, dp);
    }

    private int f(String[] strs, int i, int z, int o, int[][][] dp) {
        if (i == strs.length) {
            return 0;
        }
        if (dp[i][z][o] != -1) {
            return dp[i][z][o];
        }
        // 情况1：不选当前
        int p1 = f(strs, i + 1, z, o, dp);
        // 情况2：选当前
        countZerosAndOnes(strs[i]);
        int p2 = 0;
        if (z >= zeros && o >= ones) {
            p2 = 1 + f(strs, i + 1, z - zeros, o - ones, dp);
        }
        dp[i][z][o] = Math.max(p1, p2);
        return dp[i][z][o];
    }

    private void countZerosAndOnes(String s) {
        zeros = ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones++;
            }
        }
    }
}
