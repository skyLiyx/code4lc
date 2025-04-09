package lyx.lc.c10;

/**
 * 1004. 最大连续1的个数 III
 */
public class Lc1004 {
    public int longestOnes(int[] nums, int k) {
        int cnt = 0;
        int ans = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                cnt++;
            }
            while (cnt > k) {
                if (nums[l++] == 0) {
                    cnt--;
                }
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
