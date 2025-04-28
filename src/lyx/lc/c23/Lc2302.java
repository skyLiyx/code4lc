package lyx.lc.c23;

/**
 * 2302. 统计得分小于 K 的子数组数目
 *
 * @date 2025/04/28
 */
public class Lc2302 {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long ans = 0;
        long sum = 0;
        for (int l = 0, r = 0; r < n; r++) {
            sum += nums[r];
            while (sum * (r - l + 1) >= k) {
                sum -= nums[l++];
            }
            ans += (r - l + 1);
        }
        return ans;
    }
}
