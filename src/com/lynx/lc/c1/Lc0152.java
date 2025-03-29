package com.lynx.lc.c1;

/**
 * 152. 乘积最大子数组
 */
public class Lc0152 {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        for (int i = 1, min = nums[0], max = nums[0], curMin, curMax; i < nums.length; i++) {
            curMin = Math.min(nums[i], Math.min(nums[i] * min, nums[i] * max));
            curMax = Math.max(nums[i], Math.max(nums[i] * min, nums[i] * max));
            min = curMin;
            max = curMax;
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
