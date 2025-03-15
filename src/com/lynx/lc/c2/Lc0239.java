package com.lynx.lc.c2;

import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 */
public class Lc0239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
            a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]
        );
        for (int i = 0; i < k - 1; i++) {
            pq.add(new int[]{nums[i], i});
        }
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int l = 0, r = k - 1; r < n; l++, r++) {
            pq.offer(new int[]{nums[r], r});
            while (pq.peek()[1] <= l) {
                pq.poll();
            }
            ans[r] = pq.peek()[0];
        }
        return ans;
    }
}
