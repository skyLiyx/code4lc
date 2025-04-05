package lyx.lc.c27;

import java.util.Arrays;

/**
 * 2770. 达到末尾下标所需的最大跳跃次数
 */
public class Lc2770 {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (dp[j] != 0 && Math.abs(nums[j] - nums[i]) <= target) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > n - j) {
                        break;
                    }
                }
            }
        }
        return dp[0] - 1;
    }

    /**
     * 暴力递归.
     */
    public int maximumJumps1(int[] nums, int target) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -2);
        return f(nums, 0, target, dp);
    }

    private int f(int[] nums, int i, int target, int[] dp) {
        if (i == nums.length - 1) {
            return 0;
        }
        if (dp[i] != -2) {
            return dp[i];
        }
        int ans = -1;
        for (int j = i + 1; j < nums.length; j++) {
            if (Math.abs(nums[j] - nums[i]) <= target) {
                int next = f(nums, j, target, dp);
                if (next != -1) {
                    ans = Math.max(ans, next + 1);
                }
            }
            if (ans > nums.length - j) {
                break;
            }
        }
        dp[i] = ans;
        return dp[i];
    }
}
