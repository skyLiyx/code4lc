package lyx.lc.c28;

import java.util.*;

/**
 * 2841. 几乎唯一子数组的最大和
 */
public class Lc2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        long ans = 0;
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k - 1; i++) {
            sum += nums.get(i);
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
        }
        for (int i = k - 1; i < nums.size(); i++) {
            sum += nums.get(i);
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            if (map.size() >= m) {
                ans = Math.max(ans, sum);
            }
            sum -= nums.get(i - k + 1);
            int count = map.get(nums.get(i - k + 1)) - 1;
            if (count == 0) {
                map.remove(nums.get(i - k + 1)); // 通过map.size()判断个数，计数为0的就必须删除
            } else {
                map.put(nums.get(i - k + 1), count);
            }
        }
        return ans;
    }
}
