package lyx.lc.c14;

/**
 * 1499. 满足不等式的最大值
 *
 * @apiNote 单调队列
 */
public class Lc1499 {
    private final int[] deque = new int[100001];
    private int h, t;

    public int findMaxValueOfEquation(int[][] points, int k) {
        // yi + yj + |xi - xj| 要最大，数据以x坐标排序，那么也就是yj + xj + yi - xi
        // 以j点为准，即yj和xj不变的前提下，yi - xi要尽量大，且xi在[xj - k, xj - 1]范围
        // 可以用单调递减队列，维护yi - xi
        h = t = 0;
        int ans = Integer.MIN_VALUE;
        int n = points.length;
        for (int j = 0, x, y; j < n; j++) {
            // 当前来到j点，首先维护队列内的点要在[xj - k, xj - 1]范围内
            x = points[j][0];
            y = points[j][1];
            while (h < t && x - points[deque[h]][0] > k) {
                h++;
            }
            if (h < t) {
                // 队列里有点才能统计
                ans = Math.max(ans, x + y + points[deque[h]][1] - points[deque[h]][0]);
            }
            // 当前点入队列，保持单调递减
            while (h < t && y - x >= points[deque[t - 1]][1] - points[deque[t - 1]][0]) {
                t--;
            }
            deque[t++] = j;
        }
        return ans;
    }
}
