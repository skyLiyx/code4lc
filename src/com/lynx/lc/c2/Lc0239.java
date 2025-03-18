package com.lynx.lc.c2;

/**
 * 239. 滑动窗口最大值
 *
 * @apiNote 单调队列
 */
public class Lc0239 {
    private final int[] deque = new int[100000];
    private int h, t;

    public int[] maxSlidingWindow(int[] nums, int k) {
        h = t = 0;
        // 先形成k-1长度的窗口
        for (int i = 0; i < k - 1; i++) {
            while (h < t && nums[deque[t - 1]] <= nums[i]) {
                t--;
            }
            deque[t++] = i;
        }
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int l = 0, r = k - 1; r < n; l++, r++) {
            // 右边进来
            while (h < t && nums[deque[t - 1]] <= nums[r]) {
                t--;
            }
            deque[t++] = r;
            // 记录最大值
            ans[l] = nums[deque[h]];
            // 左边出去
            if (l == deque[h]) {
                h++;
            }
        }
        return ans;
    }
}
