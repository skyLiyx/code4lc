package lyx.lc.c7;

/**
 * 713. 乘积小于 K 的子数组
 */
public class Lc0713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2) {
            return 0;
        }
        int ans = 0;
        for (int l = 0, r = 0, res = 1; r < nums.length; r++) {
            res *= nums[r];
            while (res >= k) {
                res /= nums[l];
                l++;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
