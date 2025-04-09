package lyx.lc.c25;

import java.util.Arrays;

/**
 * 2563. 统计公平数对的数目
 */
public class Lc2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long result = 0;
        int left = nums.length;
        int right = nums.length;
        for (int i = 0; i < nums.length; i++) {
            // 随着i增大, right和left只可能减小
            while (right > 0 && nums[right - 1] > upper - nums[i]) {
                right--;
            }
            while (left > 0 && nums[left - 1] >= lower - nums[i]) {
                left--;
            }
            result += Math.min(i, right) - Math.min(i, left);
        }
        return result;
    }
}
