package com.lynx.lc.c18;

import java.util.HashMap;
import java.util.Map;

/**
 * 1814. 统计一个数组中好对子的数目
 */
public class Lc1814 {
    private static final int MOD = (int)1e9 + 7;

    public int countNicePairs(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums[i] -= rev(nums[i]);
            if (map.containsKey(nums[i])) {
                ans = (ans + map.get(nums[i])) % MOD;
            }
            map.merge(nums[i], 1, Integer::sum);
        }
        return ans;
    }

    private int rev(int num) {
        int ans = 0;
        while (num != 0) {
            ans = ans * 10 + num % 10;
            num /= 10;
        }
        return ans;
    }
}
