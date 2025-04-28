package lyx.lc.c28;

import java.util.List;

/**
 * 2845. 统计趣味子数组的数目
 *
 * @date 2025/04/25
 */
public class Lc2845 {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        long ans = 0;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (nums.get(i) % modulo == k ? 1 : 0);
        }
        int[] cnt = new int[Math.min(n + 1, modulo)];
        for (int s : sum) {
            if (s >= k) {
                ans += cnt[(s - k) % modulo];
            }
            cnt[s % modulo]++;
        }
        return ans;
    }
}