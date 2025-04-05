package lyx.lc.c1;

/**
 * 123. 买卖股票的最佳时机 III
 */
public class Lc0123 {
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        // dp1[i]: 前i天交易一次的最大收益
        int[] dp1 = new int[n];
        for (int i = 1, min = prices[0]; i < n; i++) {
            // 今天不卖 pk 今天卖
            dp1[i] = Math.max(dp1[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        // dp2[i]: 第i天交易第二次的最大收益
        int[] dp2 = new int[n];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            // 枚举第j天买第二次
            for (int j = 0; j <= i; j++) {
                dp2[i] = Math.max(dp2[i], dp1[j] + prices[i] - prices[j]);
                ans = Math.max(ans, dp2[i]);
            }
        }
        return ans;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        // dp1[i]: 前i天交易一次的最大收益
        int[] dp1 = new int[n];
        for (int i = 1, min = prices[0]; i < n; i++) {
            // 今天不卖 pk 今天卖
            dp1[i] = Math.max(dp1[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        // best[i]: 前i天买第二次的最大收益
        int[] best = new int[n];
        best[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 今天不买 pk 今天买
            best[i] = Math.max(best[i - 1], dp1[i] - prices[i]);
        }
        // 第i天交易第二次的最大收益
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, best[i] + prices[i]);
        }
        return ans;
    }

    public int maxProfit3(int[] prices) {
        int n = prices.length;
        // dp1[i]: 前i天交易一次的最大收益
        int[] dp1 = new int[n];
        // best[i]: 前i天买第二次的最大收益
        int[] best = new int[n];
        best[0] = -prices[0];
        int ans = 0;
        for (int i = 1, min = prices[0]; i < n; i++) {
            // 今天不卖第一次 pk 今天卖第一次
            dp1[i] = Math.max(dp1[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
            // 今天不买第二次 pk 今天买第二次
            best[i] = Math.max(best[i - 1], dp1[i] - prices[i]);
            // 今天卖第二次
            ans = Math.max(ans, best[i] + prices[i]);
        }
        return ans;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp1[i]: 前i天交易一次的最大收益
        int dp1 = 0;
        // best[i]: 前i天买第二次的最大收益
        int best = -prices[0];
        int ans = 0;
        for (int i = 1, min = prices[0]; i < n; i++) {
            // 今天不卖第一次 pk 今天卖第一次
            dp1 = Math.max(dp1, prices[i] - min);
            min = Math.min(min, prices[i]);
            // 今天不买第二次 pk 今天买第二次
            best = Math.max(best, dp1 - prices[i]);
            // 今天卖第二次
            ans = Math.max(ans, best + prices[i]);
        }
        return ans;
    }
}
