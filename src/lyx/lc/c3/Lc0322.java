package lyx.lc.c3;

/**
 * 322. 零钱兑换
 *
 * @apiNote 完全背包
 */
public class Lc0322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // dp[i][j]: 使用前 i 个硬币组成金额 j 的最小个数
        int[] dp = new int[amount + 1];
        for (int j = 1; j <= amount; j++) {
            dp[j] = Integer.MAX_VALUE >> 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = coins[i - 1]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
            }
        }
        return dp[amount] < (Integer.MAX_VALUE >> 1) ? dp[amount] : -1;
    }
}
