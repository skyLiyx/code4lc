package lyx.lc.c16;

/**
 * 1695. 删除子数组的最大得分
 */
public class Lc1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int[] count = new int[10001];
        int type = 0;
        int ans = 0, sum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            if (count[nums[r]]++ == 0) {
                type++;
            }
            while (type < r - l + 1) {
                sum -= nums[l];
                if (--count[nums[l++]] == 0) {
                    type--;
                }
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
