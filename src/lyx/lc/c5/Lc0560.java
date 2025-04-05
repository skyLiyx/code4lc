package lyx.lc.c5;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 */
public class Lc0560 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0, sum = 0, want; i < nums.length; i++) {
            sum += nums[i];
            want = sum - k;
            ans += map.getOrDefault(want, 0);
            map.merge(sum, 1, Integer::sum);
        }
        return ans;
    }
}
