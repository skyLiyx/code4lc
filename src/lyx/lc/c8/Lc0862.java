package lyx.lc.c8;

import java.util.Arrays;

/**
 * 862. 和至少为 K 的最短子数组
 *
 * @apiNote 单调队列
 */
public class Lc0862 {
    private final long[] sum = new long[100001];
    private final int[] deque = new int[100001];
    private int h, t;

    public int shortestSubarray(int[] nums, int k) {
        h = t = 0;
        int n = nums.length;
        Arrays.fill(sum, 0, n + 1, 0);
        for (int i = 1; i <= n; i++) {
            // 表示前i个数的和，sum[0]就是前0个数的和为0
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            // 前i个数的前缀和
            while (h < t && sum[i] - sum[deque[h]] >= k) {
                // 判断当前前缀和 - 头部前缀和，达标
                ans = Math.min(ans, i - deque[h++]);
            }
            // 从尾部进入，保持单调递增
            while (h < t && sum[i] <= sum[deque[t - 1]]) {
                t--;
            }
            deque[t++] = i;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
