package com.lynx.lc.c0;

/**
 * 53. 最大子数组和
 *
 * @see com.lynx.algo.array.Kadane
 */
public class Lc0053 {
    public int maxSubArray(int[] nums) {
        int curMaxSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMaxSum = Math.max(nums[i], curMaxSum + nums[i]);
            maxSum = Math.max(maxSum, curMaxSum);
        }
        return maxSum;
    }
}
