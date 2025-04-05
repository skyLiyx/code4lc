package lyx.lc.c7;

/**
 * 714. 买卖股票的最佳时机含手续费
 */
public class Lc0714 {
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0] - fee;
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            // 当前不卖 vs 当前卖(之前买之后+当前卖出)
            sell = Math.max(sell, buy + prices[i]);
            // 当前不买 vs 当前买(之前卖之后-当前买入)
            buy = Math.max(buy, sell - prices[i] - fee);
        }
        return sell;
    }
}
