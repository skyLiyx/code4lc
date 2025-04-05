package lyx.lc.c0;

/**
 * 62.不同路径
 */
public class Lc0062 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 2][n + 2];
        dp[m][n] = 1;
        for (int y = m; y > 0 ; y--) {
            for (int x = n; x > 0; x--) {
                if (y == m && x == n) {
                    continue;
                }
                dp[y][x] = dp[y][x + 1] + dp[y + 1][x];
            }
        }
        return dp[1][1];
    }
}
