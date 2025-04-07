package lyx.lc.c4;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 *
 * @apiNote 01背包
 * @date 2025/04/07
 */
public class Lc0416 {
    public boolean canPartition(int[] nums) {
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int n = nums.length, target = sum >> 1;
        if (n == 1 || (sum & 1) == 1 || max > target) {
            return false;
        }
        Arrays.sort(nums);
        // dp[i][j]: 前i个数字任选，能否组成累加和为j的子序列
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }
        return dp[target];
    }


    /**
     * 记忆化搜索版本。
     *
     * @param nums   原数组，固定参数
     * @param i      当前位置
     * @param target 目标值
     * @param dp     缓存
     */
    public boolean f(int[] nums, int i, int target, int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (i == nums.length || target < 0) {
            return false;
        }
        if (dp[i][target] != 0) {
            return dp[i][target] == 1;
        }
        // 不要当前数
        boolean ans = f(nums, i + 1, target, dp);
        // 要当前数
        dp[i][target] = ans || f(nums, i + 1, target - nums[i], dp) ? 1 : -1;
        return dp[i][target] == 1;
    }
}
