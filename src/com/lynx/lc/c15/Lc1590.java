package com.lynx.lc.c15;

import java.util.HashMap;
import java.util.Map;

/**
 * 1590. 使数组和能被 P 整除
 */
public class Lc1590 {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int mod = (int) (sum % p);
        if (mod == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        // 模p值，最后出现的位置
        map.put(0, -1);
        for (int i = 0, cur = 0, want; i < nums.length; i++) {
            // 0~i范围和的模
            cur = (cur + nums[i]) % p;
            // 如果选当前位置为移除子数组的结尾，那么该子数组左边界之前的范围和的模p值
            // 就必须满足条件
            want = cur < mod ? (cur + p - mod) : (cur - mod);
            if (map.containsKey(want)) {
                ans = Math.min(ans, i - map.get(want));
            }
            map.put(cur, i);
        }
        return ans == nums.length ? -1 : ans;
    }
}
