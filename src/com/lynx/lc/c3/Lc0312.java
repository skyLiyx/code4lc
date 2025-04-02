package com.lynx.lc.c3;

/**
 * 312. 戳气球
 */
public class Lc0312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, n);
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = arr[i - 1] * arr[i] * arr[i + 1];
        }
        for (int l = n; l >= 1; l--) {
            for (int r = l + 1; r <= n; r++) {
                dp[l][r] = Math.max(
                        nums[l - 1] * nums[l] * nums[r + 1] + dp[l + 1][r],
                        nums[l - 1] * nums[r] * nums[r + 1] + dp[l][r - 1]);
                for (int i = l + 1; i < r; i++) {
                    dp[l][r] = Math.max(dp[l][r],
                            nums[l - 1] * nums[i] * nums[r + 1] + dp[l][i - 1] + dp[i + 1][r]);
                }
            }
        }
        return dp[1][n];
    }

    /**
     * 暴力递归. 尝试每个位置的气球最后打爆, 这样才能确保两边的气球一定没有爆.
     */
    private int f(int[] nums, int l, int r, int[][] dp) {
        if (l == r) {
            return nums[l - 1] * nums[l] * nums[r + 1];
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        int ans = Math.max(
                nums[l - 1] * nums[l] * nums[r + 1] + f(nums, l + 1, r, dp),
                nums[l - 1] * nums[r] * nums[r + 1] + f(nums, l, r - 1, dp));
        for (int i = l + 1; i < r; i++) {
            ans = Math.max(ans,
                    nums[l - 1] * nums[i] * nums[r + 1] + f(nums, l, i - 1, dp) + f(nums, i + 1, r, dp));
        }
        dp[l][r] = ans;
        return dp[l][r];
    }
}
