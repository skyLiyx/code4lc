package lyx.lc.c1;

/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class Lc0153 {
    public int findMin(int[] nums) {
        int n = nums.length, l = 0, r = n - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            // l和r同时向交界靠拢, r最终在交界前一个位置(<=的缘故)
            if (nums[m] <= nums[n - 1]) {
                // 落在右半部分
                r = m - 1;
            } else {
                // 落在左半部分
                l = m + 1;
            }
        }
        return nums[r + 1];
    }
}
