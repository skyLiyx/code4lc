package lyx.lc.c4;

/**
 * 494. 目标和
 */
public class Lc0494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target || ((sum & 1) ^ (target & 1)) == 1) {
            return 0;
        }
        // 找出一部分数累加和是A, 找出一部分数累加和是B
        // A - B = target
        // A - B + A + B = target + sum
        // A = (target + sum) / 2
        // 原问题转换成在nums数组中找出累加和是A的子序列
        return f(nums, (target + sum) / 2);
    }

    private int f(int[] nums, int target) {
        // dp[i][j]: 前 i 个元素中累加和是 j 的子序列数量
        // dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]]
        int[] dp = new int[target + 1];
        dp[0] = 1; // 累加和是0，有一个空序列
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[target];
    }
}
