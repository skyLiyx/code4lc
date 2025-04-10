package lyx.lc.c1;

import java.util.HashMap;
import java.util.Map;

/**
 * 128. 最长连续序列
 */
public class Lc0128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int n : nums) {
            if (map.containsKey(n)) continue;
            int left = map.getOrDefault(n - 1, 0);
            int right = map.getOrDefault(n + 1, 0);
            int sum = left + right + 1;
            ans = Math.max(ans, sum);
            map.put(n, sum);
            if (left != 0) map.put(n - left, sum);
            if (right != 0) map.put(n + right, sum);
        }
        return ans;
    }
}
