package lyx.lc.c18;

import java.util.Arrays;

/**
 * 1838. 最高频元素的频数
 */
public class Lc1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] == nums[0]) {
            return nums.length;
        }
        int ans = 1;
        long d = 0;
        for (int l = 0, r = 1, max = nums[0]; r < nums.length; r++) {
            if (nums[r] > max) {
                d += (long) (r - l) * (nums[r] - max);
                max = nums[r];
            }
            if (nums[r] < max) {
                d += max - nums[r];
            }
            while (d > k) {
                d -= max - nums[l++];
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
