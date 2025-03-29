package com.lynx.lc.c25;

/**
 * 2560. 打家劫舍 IV
 */
public class Lc2560 {
    public int minCapability(int[] nums, int k) {
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int num : nums) {
            l = Math.min(l, num);
            r = Math.max(r, num);
        }
        int m;
        int ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (check(nums, m, k)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private boolean check(int[] nums, int m, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (m >= nums[i]) {
                // 可以偷
                count++;
                i++; // 跳过下一个房间
            }
        }
        return count >= k;
    }
}
