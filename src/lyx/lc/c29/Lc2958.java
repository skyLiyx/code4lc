package lyx.lc.c29;

import java.util.HashMap;
import java.util.Map;

/**
 * 2958. 最多 K 个重复元素的最长子数组
 */
public class Lc2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int ans = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            int rf = freq.getOrDefault(nums[r], 0) + 1;
            freq.put(nums[r], rf);
            while (rf > k) {
                freq.put(nums[l], freq.get(nums[l]) - 1);
                if (nums[l++] == nums[r]) {
                    rf--;
                }
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
