package lyx.lc.c34;

/**
 * 3439. 重新安排会议得到最多空余时间 I
 */
public class Lc3439 {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        // 统计所有空闲时段
        int[] free = new int[n + 1];
        free[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            free[i] = startTime[i] - endTime[i - 1];
        }
        free[n] = eventTime - endTime[n - 1];
        // 移动k个会议时段 相当于 移动k+1个空闲时段
        k++;
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < k - 1; i++) {
            sum += free[i];
        }
        for (int i = k - 1; i <= n; i++) {
            sum += free[i];
            ans = Math.max(ans, sum);
            sum -= free[i - k + 1];
        }
        return ans;
    }
}
