package lyx.lc.c7;

/**
 * 795. 区间子数组个数
 */
public class Lc0795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0;
        for (int i = 0, j = -1, cnt = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                // 维护区间子数组左边界
                j = i;
            }
            if (nums[i] >= left) {
                // 维护当前区间可计数数量
                cnt = i - j;
            }
            ans += cnt;
        }
        return ans;
    }
}
