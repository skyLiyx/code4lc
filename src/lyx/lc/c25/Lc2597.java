package lyx.lc.c25;

import java.util.HashMap;
import java.util.Map;

/**
 * 2597.美丽子集的数目
 *
 * @date 2025/03/07
 */
public class Lc2597 {
    private int ans = 0;
    private Map<Integer, Integer> cnt = new HashMap<>();

    public int beautifulSubsets(int[] nums, int k) {
        dfs(nums, k, 0);
        return ans - 1;
    }

    public void dfs(int[] nums, int k, int i) {
        if (i == nums.length) {
            ans++;
            return;
        }
        dfs(nums, k, i + 1);
        if (cnt.getOrDefault(nums[i] - k, 0) == 0 && cnt.getOrDefault(nums[i] + k, 0) == 0) {
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            dfs(nums, k, i + 1);
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) - 1);
        }
    }
}
