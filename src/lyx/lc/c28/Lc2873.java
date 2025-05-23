package lyx.lc.c28;

/**
 * 2873. 有序三元组中的最大值 I
 *
 * @date 2025/04/02
 */
public class Lc2873 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0;
        long maxDiff = nums[0] - nums[1];
        int max = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            ans = Math.max(ans, maxDiff * nums[i]);
            maxDiff = Math.max(maxDiff, max - nums[i]);
            max = Math.max(max, nums[i]);
        }
        return ans;
    }
}
