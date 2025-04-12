package lyx.lc.c0;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class Lc0034 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length, l = 0, r = n - 1, m;
        int firstGreatThan = n, lastLessThan = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] > target) {
                firstGreatThan = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        l = 0;
        r = n - 1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m - 1;
            } else {
                lastLessThan = m;
                l = m + 1;
            }
        }
        if (lastLessThan + 1 == firstGreatThan) {
            return new int[]{-1, -1};
        }
        return new int[]{lastLessThan + 1, firstGreatThan - 1};
    }
}
