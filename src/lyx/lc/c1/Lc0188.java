package lyx.lc.c1;

/**
 * 188. 买卖股票的最佳时机 IV
 *
 * @see Lc0122
 */
public class Lc0188 {
    public int maxProfit1(int[] prices, int k) {
        int n = prices.length;
        if (k >= n / 2) {
            // 递增区间的最大数量就是n/2
            // k大于等于这个值时就相当于无限交易
            return unlimited(prices);
        }
        // dp[i][j]: 前j天交易i次的最大收益
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                // 情况1：当前不卖
                dp[i][j] = dp[i][j - 1];
                // 情况2：当天卖
                for (int l = 0; l < j; l++) {
                    // 枚举第l天买的
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][l] - prices[l] + prices[j]);
                }
            }
        }
        return dp[k][n - 1];
    }

    public int maxProfit2(int[] prices, int k) {
        int n = prices.length;
        if (k >= n / 2) {
            return unlimited(prices);
        }
        // dp[i][j]: 前j天交易i次的最大收益
        int[][] dp = new int[k + 1][n];
        for (int i = 1, best; i <= k; i++) {
            best = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                // 情况1：当前不卖
                dp[i][j] = dp[i][j - 1];
                // 情况2：当天卖
                dp[i][j] = Math.max(dp[i][j], best + prices[j]);
                best = Math.max(best, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }

    /**
     * 空间压缩最终版本.
     */
    public int maxProfit(int[] prices, int k) {
        int n = prices.length;
        if (k >= n / 2) {
            return unlimited(prices);
        }
        // dp[i][j]: 前j天交易i次的最大收益
        int[] dp = new int[n];
        for (int i = 1, best; i <= k; i++) {
            best = dp[0] - prices[0];
            for (int j = 1, temp; j < n; j++) {
                temp = dp[j];
                dp[j] = Math.max(dp[j - 1], best + prices[j]);
                best = Math.max(best, temp - prices[j]);
            }
        }
        return dp[n - 1];
    }

    public int unlimited(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
