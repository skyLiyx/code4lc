package lyx.lc.c28;

import java.util.List;

/**
 * 2831. 找出最长等值子数组
 */
public class Lc2831 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        int[] cnt = new int[n + 1];
        int maxFreq = 1;
        for (int l = 0, r = 0; r < n; r++) {
            int x = nums.get(r);
            cnt[x]++;
            maxFreq = Math.max(maxFreq, cnt[x]);
            if ((r - l + 1) - maxFreq > k) {
                int y = nums.get(l++);
                cnt[y]--;
            }
        }
        return maxFreq;
    }
}
