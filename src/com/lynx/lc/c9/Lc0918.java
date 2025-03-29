package com.lynx.lc.c9;

/**
 * 918. 环形子数组的最大和
 */
public class Lc0918 {
    public int maxSubarraySumCircular(int[] nums) {
        // 要么是中间连续的，要么是头尾相接的
        // 头尾相接的可以看做总和减去子数组最小和
        int all = nums[0];
        int maxSum = nums[0];
        int preMax = nums[0];
        int minSum = nums[0];
        int preMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            all += nums[i];
            preMax = Math.max(preMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, preMax);
            preMin = Math.min(preMin + nums[i], nums[i]);
            minSum = Math.min(minSum, preMin);
        }
        // 特例：整个数组全是负数
        return all == minSum ? maxSum : Math.max(maxSum, all - minSum);
    }
}
