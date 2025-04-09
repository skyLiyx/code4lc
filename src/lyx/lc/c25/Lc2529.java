package lyx.lc.c25;

/**
 * 2529. 正整数和负整数的最大计数
 */
public class Lc2529 {
    public int maximumCount(int[] nums) {
        int l = 0, r = nums.length - 1, m;
        int firstPos = nums.length, lastNeg = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] > 0) {
                firstPos = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] < 0) {
                lastNeg = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return Math.max(lastNeg + 1, nums.length - firstPos);
    }
}
