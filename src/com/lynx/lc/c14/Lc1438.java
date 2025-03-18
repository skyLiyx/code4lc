package com.lynx.lc.c14;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 *
 * @apiNote 单调队列
 */
public class Lc1438 {
    private final int[] maxDeque = new int[100000];
    private final int[] minDeque = new int[100000];
    private int maxh, maxt, minh, mint;

    public int longestSubarray(int[] nums, int limit) {
        maxh = maxt = minh = mint = 0;
        int n = nums.length;
        int ans = 0;
        for (int l = 0, r = 0; l < n; l++) {
            while (r < n && ok(nums, limit, r)) {
                push(nums, r++);
            }
            ans = Math.max(ans, r - l);
            pop(l);
        }
        return ans;
    }

    private boolean ok(int[] nums, int limit, int r) {
        int max = maxh < maxt ? Math.max(nums[maxDeque[maxh]], nums[r]) : nums[r];
        int min = minh < mint ? Math.min(nums[minDeque[minh]], nums[r]) : nums[r];
        return max - min <= limit;
    }

    private void push(int[] nums, int r) {
        // 维护最大值
        while (maxh < maxt && nums[maxDeque[maxt - 1]] <= nums[r]) {
            maxt--;
        }
        maxDeque[maxt++] = r;
        // 维护最小值
        while (minh < mint && nums[minDeque[mint - 1]] >= nums[r]) {
            mint--;
        }
        minDeque[mint++] = r;
    }

    private void pop(int l) {
        if (maxh < maxt && maxDeque[maxh] == l) {
            maxh++;
        }
        if (minh < mint && minDeque[minh] == l) {
            minh++;
        }
    }
}
