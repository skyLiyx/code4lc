package lyx.lc.c0;

/**
 * 64.最小路径和
 *
 * @apiNote 动态规划
 */
public class Lc0064 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        // 初始化第一行
        for (int col = 1; col < n; col++) {
            dp[col] = dp[col - 1] + grid[0][col];
        }
        for (int row = 1; row < m; row++) {
            dp[0] += grid[row][0];
            for (int col = 1; col < n; col++) {
                // 当前最短路径和 = 当前值 + 左边和上边两个之中最小的
                dp[col] = grid[row][col] + Math.min(dp[col], dp[col - 1]);
            }
        }
        return dp[n - 1];
    }
}
