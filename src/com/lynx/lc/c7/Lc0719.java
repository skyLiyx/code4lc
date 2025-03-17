package com.lynx.lc.c7;

import java.util.Arrays;

/**
 * 719. 找出第 K 小的数对距离
 *
 * @apiNote 二分查找
 */
public class Lc0719 {
    public int smallestDistancePair(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = nums[n - 1] - nums[0], m;
        while (l <= r) {
            // m表示当前预期的第k小的值，然后检查小于等于这个值有多少对
            // 如果大于等于k，说明预期大了，往左边寻找
            // 如果小于k，说明预期小了，往右边寻找
            m = l + (r - l) / 2;
            if (check(nums, k, m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private boolean check(int[] nums, int k, int m) {
        int ans = 0;
        for (int l = 0, r = 0; l < nums.length; l++) {
            while (r + 1 < nums.length && nums[r + 1] - nums[l] <= m) {
                r++;
            }
            ans += r - l;
        }
        return ans >= k;
    }
}
