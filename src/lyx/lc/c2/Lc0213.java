package lyx.lc.c2;

/**
 * 213. 打家劫舍 II
 */
public class Lc0213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(nums[0] + f(nums, 2, n - 2), f(nums, 1, n - 1));
    }

    private int f(int[] nums, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l == r) {
            return nums[l];
        }
        if (l + 1 == r) {
            return Math.max(nums[l], nums[r]);
        }
        int prePre = 0;
        int pre = nums[l];
        for (int i = l + 1, cur; i <= r; i++) {
            cur = Math.max(pre, prePre + nums[i]);
            prePre = pre;
            pre = cur;
        }
        return pre;
    }
}
