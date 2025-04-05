package lyx.lc.c8;

import java.util.Arrays;

/**
 * 826. 安排工作以达到最大收益
 */
public class Lc0826 {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] work = new int[n][2];
        for (int i = 0; i < n; i++) {
            work[i][0] = difficulty[i];
            work[i][1] = profit[i];
        }
        // 工作按难度从小到大、收益从小到大排序
        Arrays.sort(work, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        // 工人按能力从小到大排序
        Arrays.sort(worker);

        int ans = 0;
        for (int i = 0, j = -1, max = 0; i < worker.length; i++) {
            // 获取难度不大于当前工人能力的工作
            while (j + 1 < n && work[j + 1][0] <= worker[i]) {
                max = Math.max(max, work[++j][1]);
            }
            if (j != -1) {
                ans += max;
            }
        }
        return ans;
    }
}
