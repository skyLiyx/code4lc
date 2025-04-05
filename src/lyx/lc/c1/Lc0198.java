package lyx.lc.c1;

/**
 * 198.打家劫舍
 */
public class Lc0198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        // 初始化dp[n]和dp[n+1]为0
        for (int i = n - 1; i >= 0; i--) {
            int rob = nums[i] + dp[i + 2];
            int notRob = dp[i + 1];
            dp[i] = Math.max(rob, notRob);
        }
        return dp[0];
    }
}
