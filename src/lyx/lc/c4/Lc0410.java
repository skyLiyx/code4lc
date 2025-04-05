package lyx.lc.c4;

/**
 * 410. 分割数组的最大值
 *
 * @apiNote 二分查找
 */
public class Lc0410 {
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int ans = 0;
        int l = 0, r = sum, m;
        while (l <= r) {
            // 当前每一个子数组的最大值为m，以此为条件判断其是否能分成k个
            // 不能就缩小，能就扩大
            m = l + (r - l) / 2;
            if (check(nums, m) <= k) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private int check(int[] nums, int max) {
        int part = 1;
        for (int i = 0, s = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                return Integer.MAX_VALUE;
            }
            if (s + nums[i] > max) {
                s = nums[i];
                part++;
            } else {
                s += nums[i];
            }
        }
        return part;
    }
}
