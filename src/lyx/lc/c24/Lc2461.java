package lyx.lc.c24;

/**
 * 2461. 长度为 K 子数组中的最大和
 */
public class Lc2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long sum = 0;
        int[] count = new int[100001];
        int size = 0;
        for (int i = 0; i < k - 1; i++) {
            sum += nums[i];
            if (count[nums[i]]++ == 0) {
                size++;
            }
        }
        for (int i = k - 1; i < nums.length; i++) {
            sum += nums[i];
            if (count[nums[i]]++ == 0) {
                size++;
            }
            if (size == k) {
                ans = Math.max(ans, sum);
            }
            sum -= nums[i - k + 1];
            if (--count[nums[i - k + 1]] == 0) {
                size--;
            }
        }
        return ans;
    }
}
