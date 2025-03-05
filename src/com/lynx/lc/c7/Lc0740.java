package com.lynx.lc.c7;

/**
 * 740.删除并获得点数
 */
public class Lc0740 {
    public int deleteAndEarn(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        // 构造成打家劫舍的问题
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        int[] sum = new int[maxValue + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        return rob(sum);
    }

    private int rob(int[] nums) {
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
