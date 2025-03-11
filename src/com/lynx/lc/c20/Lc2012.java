package com.lynx.lc.c20;

/**
 * 2012.数组美丽值求和
 *
 * @date 2025/03/11
 */
public class Lc2012 {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        // 0 ~ i之间的最大值
        int[] maxs = new int[n];
        // i ~ n-1之间的最小值
        int[] mins = new int[n];
        int max = -100001;
        int min = 100001;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            maxs[i] = max;
        }
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            mins[i] = min;
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > maxs[i - 1] && nums[i] < mins[i + 1]) {
                ans += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                ans += 1;
            }
        }
        return ans;
    }
}
