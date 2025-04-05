package lyx.lc.c23;

/**
 * 2398. 预算内的最多机器人数目
 *
 * @apiNote 单调队列
 */
public class Lc2398 {
    private static final int MAXN = 50001;
    private final int[] deque = new int[MAXN];
    private int h, t;

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        h = t = 0;
        int n = chargeTimes.length;
        long runningCostSum = 0;
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            // l - r范围内的累加和
            runningCostSum += runningCosts[r];
            // 维护单调递减
            while (h < t && chargeTimes[deque[t - 1]] <= chargeTimes[r]) {
                t--;
            }
            deque[t++] = r;
            // 如果当前范围超过了限制，右移l
            while (l <= r && chargeTimes[deque[h]] + runningCostSum * (r - l + 1) > budget) {
                if (h < t && deque[h] == l) {
                    h++;
                }
                runningCostSum -= runningCosts[l++];
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
