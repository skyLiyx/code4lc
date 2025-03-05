package com.lynx.lc.c0;

/**
 * 63.不同路径 II
 */
public class Lc0063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int y = 0; y < m + 1; y++) {
            dp[y][n] = 0;
        }
        for (int x = 0; x < n + 1; x++) {
            dp[m][x] = 0;
        }
        dp[m - 1][n - 1] = 1;
        for (int y = m - 1; y >= 0; y--) {
            for (int x = n - 1; x >= 0; x--) {
                if (y == m - 1 && x == n - 1) {
                    continue;
                }
                if (obstacleGrid[y][x] == 1) {
                    dp[y][x] = 0;
                } else {
                    dp[y][x] = dp[y + 1][x] + dp[y][x + 1];
                }
            }
        }
        return dp[0][0];
    }

    /**
     * 暴力递归版本。
     */
    private int recur(int[][] obstacleGrid, int y, int x) {
        if (y == obstacleGrid.length || x == obstacleGrid[y].length) {
            return 0;
        }
        if (obstacleGrid[y][x] == 1) {
            // 考虑目标位置也可能为1，这个条件必须先判断
            return 0;
        }
        if (y == obstacleGrid.length - 1 && x == obstacleGrid[y].length - 1) {
            // 到达目标位置时，路径+1
            return 1;
        }
        // 最终就是往下走的路径加上往右走的路径
        return recur(obstacleGrid, y + 1, x) + recur(obstacleGrid, y, x + 1);
    }
}
