package lyx.lc.c12;

/**
 * 1283. 使结果不超过阈值的最小除数
 */
public class Lc1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = nums[0], m;
        // 除数的最大值就是数组最大值, 整除向上取整的情况下再大也无意义
        for (int i = 1; i < nums.length; i++) {
            r = Math.max(r, nums[i]);
        }
        int ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (check(nums, m, threshold)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private boolean check(int[] nums, int mid, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (num - 1) / mid + 1;
        }
        return sum <= threshold;
    }
}
