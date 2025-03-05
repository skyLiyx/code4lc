package com.lynx.lc.c0;

/**
 * 64.最小路径和
 */
public class Lc0064 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = -1;
        }
        for (int i = 0; i <= n; i++) {
            dp[m][i] = -1;
        }
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int y = m - 1; y >= 0; y--) {
            for (int x = n - 1; x >= 0; x--) {
                if (y == m - 1 && x == n - 1) {
                    continue;
                }
                int down = dp[y + 1][x];
                int right = dp[y][x + 1];
                if (down == -1 && right == -1) {
                    dp[y][x] = -1;
                } else if (down == -1) {
                    dp[y][x] = grid[y][x] + right;
                } else if (right == -1) {
                    dp[y][x] = grid[y][x] + down;
                } else {
                    dp[y][x] = grid[y][x] + Math.min(down, right);
                }
            }
        }
        return dp[0][0];
    }
}
