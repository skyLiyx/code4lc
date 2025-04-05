package lyx.lc.c1;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @apiNote 无限次交易，只需抓住递增的区间就可以
 */
public class Lc0122 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
