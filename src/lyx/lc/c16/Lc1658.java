package lyx.lc.c16;

/**
 * 1658. 将 x 减到 0 的最小操作数
 */
public class Lc1658 {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (x > total) {
            return -1;
        }
        // 逆向思维：找出累加和是 total - x 的最长子数组
        int sum = 0;
        int ans = -1;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum > total - x) {
                sum -= nums[l++];
            }
            if (sum == total - x) {
                ans = Math.max(ans, r - l + 1);
            }
        }
        return ans == -1 ? -1 : nums.length - ans;
    }
}
