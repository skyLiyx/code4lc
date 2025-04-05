package lyx.lc.c3;

/**
 * 309. 买卖股票的最佳时机含冷冻期
 */
public class Lc0309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int buy = Math.max(-prices[0], -prices[1]);
        int sell2 = 0;
        int sell1 = Math.max(0, prices[1] - prices[0]);
        for (int i = 2, temp; i < n; i++) {
            temp = sell1;
            // 当前不卖 vs 当前卖
            sell1 = Math.max(sell1, buy + prices[i]);
            // 当前不买 vs 当前买
            buy = Math.max(buy, sell2 - prices[i]);
            sell2 = temp;
        }
        return sell1;
    }
}
