package lyx.lc.c9;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 901. 股票价格跨度
 */
public class Lc0901 {

    public static class StockSpanner {
        Deque<int[]> stack;
        public int days;

        public StockSpanner() {
            stack = new ArrayDeque<>();
            stack.push(new int[]{Integer.MAX_VALUE, -1});
            days = 0;
        }

        public int next(int price) {
            while (price >= stack.peek()[0]) {
                stack.pop();
            }
            int ans = days - stack.peek()[1];
            stack.push(new int[]{price, days++});
            return ans;
        }
    }
}
