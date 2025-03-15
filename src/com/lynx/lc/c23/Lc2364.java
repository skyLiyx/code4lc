package com.lynx.lc.c23;

import java.util.HashMap;
import java.util.Map;

/**
 * 2364. 统计坏数对的数目
 */
public class Lc2364 {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums[i] -= i;
            // 统计非坏数对的数量
            // 即 j > i && nums[j] - j == nums[i] - i
            if (map.containsKey(nums[i])) {
                ans += map.get(nums[i]);
            }
            map.merge(nums[i], 1, Integer::sum);
        }
        // 能组成对的数量 - 非坏数对的数量
        return (long)n * (n - 1) / 2 - ans;
    }
}
