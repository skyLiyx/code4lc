package lyx.lc.c14;

/**
 * 1475. 商品折扣后的最终价格
 */
public class Lc1475 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] stack = new int[n];
        int size = 0;
        for (int i = 0; i < prices.length; i++) {
            while (size > 0 && prices[i] <= prices[stack[size - 1]]) {
                prices[stack[--size]] -= prices[i];
            }
            stack[size++] = i;
        }
        return prices;
    }
}
