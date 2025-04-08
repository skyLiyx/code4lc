package lyx.lc.c14;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 */
public class Lc1493 {
    public int longestSubarray(int[] nums) {
        int count = 0, ans = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                count++;
            }
            while (count > 1) {
                if (nums[l++] == 0) {
                    count--;
                }
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
