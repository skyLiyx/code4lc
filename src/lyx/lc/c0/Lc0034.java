package lyx.lc.c0;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class Lc0034 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int l = 0, r = nums.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] >= target) {
                if (nums[m] == target) {
                    ans[0] = m;
                }
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] <= target) {
                if (nums[m] == target) {
                    ans[1] = m;
                }
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}
