package com.lynx.lc.c2;

/**
 * 209. 长度最小的子数组
 *
 * @apiNote 滑动窗口
 */
public class Lc0209 {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int l = 0, r = 0, sum = 0; r < nums.length; r++) {
            sum += nums[r];
            if (sum < target) {
                continue;
            }
            while (sum - nums[l] >= target) {
                sum -= nums[l];
                l++;
            }
            ans = Math.min(ans, r - l + 1);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
