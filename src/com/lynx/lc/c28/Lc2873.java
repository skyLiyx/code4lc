package com.lynx.lc.c28;

/**
 * 2873. 有序三元组中的最大值 I
 *
 * @date 2025/04/02
 */
public class Lc2873 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 1; i < n - 1; i++) {
            // [0,i)范围的最大值
            leftMax[i] = Math.max(nums[i - 1], leftMax[i - 1]);
            // (i,n-1]范围的最大值
            rightMax[n - 1 - i] = Math.max(nums[n - i], rightMax[n - i]);
        }
        long ans = -1;
        // 枚举第二个点
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, (long) (leftMax[i] - nums[i]) * rightMax[i]);
        }
        return Math.max(0, ans);
    }
}
