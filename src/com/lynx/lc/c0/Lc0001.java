package com.lynx.lc.c0;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 */
public class Lc0001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, want; i < nums.length; i++) {
            want = target - nums[i];
            if (map.containsKey(want)) {
                return new int[]{map.get(want), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
