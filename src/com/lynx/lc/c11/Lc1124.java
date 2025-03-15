package com.lynx.lc.c11;

import java.util.HashMap;
import java.util.Map;

/**
 * 1124. 表现良好的最长时间段
 */
public class Lc1124 {
    public int longestWPI(int[] hours) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, sum = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0) {
                ans = i + 1;
            } else {
                // 当遇到前缀和不大于0时，检查之前有没有遇到更小的前缀和
                // 如果有，就说明之前那个位置到当前位置的和大于0
                if (map.containsKey(sum - 1)) {
                    ans = Math.max(ans, i - map.get(sum - 1));
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
