package lyx.lc.c25;

import java.util.HashMap;
import java.util.Map;

/**
 * 2588.统计美丽子数组数目
 *
 * @date 2025/03/06
 */
public class Lc2588 {
    public long beautifulSubarrays(int[] nums) {
        long ans = 0L;
        int mask = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            mask ^= num;
            ans += map.getOrDefault(mask, 0);
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        return ans;
    }
}