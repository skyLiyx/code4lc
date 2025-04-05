package lyx.lc.c3;

import java.util.HashMap;
import java.util.Map;

/**
 * 325. 和等于 k 的最长子数组长度
 */
public class Lc0325 {
    public int maxSubArrayLen(int[] nums, int k) {
        int ans = 0;
        // key-value: 前缀和 - 最早出现的位置
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                // 如果当前包含满足条件的前缀和
                // 当前长度 = i - 之前前缀和的最左的位置
                int len = i - map.get(sum - k);
                ans = Math.max(ans, len);
            }
            if (!map.containsKey(sum)) {
                // 仅加入一次，后续遇到不加入
                map.put(sum, i);
            }
        }
        return ans;
    }
}
