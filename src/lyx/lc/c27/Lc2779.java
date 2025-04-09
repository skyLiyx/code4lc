package lyx.lc.c27;

import java.util.Arrays;

/**
 * 2779. 数组的最大美丽值
 */
public class Lc2779 {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            while (nums[r] - nums[l] > k * 2) {
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
