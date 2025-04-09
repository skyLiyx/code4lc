package lyx.lc.c7;

/**
 * 704. 二分查找
 */
public class Lc0704 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}