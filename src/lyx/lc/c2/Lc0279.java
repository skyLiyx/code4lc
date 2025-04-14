package lyx.lc.c2;

/**
 * 279. 完全平方数
 *
 * @apiNote 完全背包
 */
public class Lc0279 {
    public int numSquares(int n) {
        int max = (int) Math.sqrt(n);
        // DP[i][j]: 使用 i 个数组成 j 的最少个数
        int[] dp = new int[n + 1];
        for (int j = 1; j < n + 1; j++) {
            dp[j] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= max; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
