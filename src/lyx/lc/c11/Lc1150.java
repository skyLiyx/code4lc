package lyx.lc.c11;

/**
 * 1150. 检查一个数是否在数组中占绝大多数
 */
public class Lc1150 {
    public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1, m;
        int left = -1; // 左边界
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] >= target) {
                left = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        l = 0;
        r = n - 1;
        int right = -1; // 右边界
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] <= target) {
                right = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return left != -1 && right != -1 && right - left + 1 > (n >> 1);
    }
}
