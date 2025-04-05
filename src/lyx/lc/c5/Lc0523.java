package lyx.lc.c5;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 */
public class Lc0523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0, mod = 0; i < nums.length; i++) {
            mod = (mod + nums[i]) % k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }
}
