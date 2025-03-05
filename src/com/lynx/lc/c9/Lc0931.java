package com.lynx.lc.c9;

/**
 * 931.下降路径最小和
 */
public class Lc0931 {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int x = 0; x < n; x++) {
            dp[m - 1][x] = matrix[m - 1][x];
        }
        for (int y = m - 2; y >= 0; y--) {
            for (int x = 0; x < n; x++) {
                int down = dp[y + 1][x];
                if (x == 0) {
                    dp[y][x] = matrix[y][x] + Math.min(down, dp[y + 1][x + 1]);
                } else if (x == n - 1) {
                    dp[y][x] = matrix[y][x] + Math.min(down, dp[y + 1][x - 1]);
                } else {
                    dp[y][x] = matrix[y][x] + Math.min(down, Math.min(dp[y + 1][x + 1], dp[y + 1][x - 1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[0][i]);
        }
        return min;
    }

    /**
     * 暴力递归版本.
     * <p>主方法中调用方法：
     * <pre>
     * int min = Integer.MAX_VALUE;
     * for (int i = 0; i < matrix[0].length; i++) {
     *     min = Math.min(min, recur(matrix, 0, i));
     * }
     * return min;
     * </pre>
     */
    private int recur(int[][] matrix, int y, int x) {
        if (y == matrix.length - 1) {
            return matrix[y][x];
        }
        int down = recur(matrix, y + 1, x);
        if (x == 0) {
            return matrix[y][x] + Math.min(down, recur(matrix, y + 1, x + 1));
        } else if (x == matrix[y].length - 1) {
            return matrix[y][x] + Math.min(down, recur(matrix, y + 1, x - 1));
        } else {
            return matrix[y][x] + Math.min(down, Math.min(recur(matrix, y + 1, x + 1), recur(matrix, y + 1, x - 1)));
        }
    }
}
