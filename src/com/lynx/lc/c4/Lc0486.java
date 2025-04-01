package com.lynx.lc.c4;

/**
 * 486. 预测赢家
 *
 * @apiNote 区间dp + 零和博弈
 */
public class Lc0486 {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        // dp[i][j]: 先手玩家在[i,j]范围内能获得的最大分数
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = nums[i];
            if (i + 1 < n) {
                dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);
            }
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = Math.max(
                        nums[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
                        nums[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
            }
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int player1 = dp[0][n - 1];
        int player2 = sum - player1;
        return player1 >= player2;
    }

    /**
     * 暴力递归. 玩家1能获得的最大分数.
     */
    private int f(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        if (l + 1 == r) {
            return Math.max(nums[l], nums[r]);
        }
        // 选左边，玩家2为了获取最好的结果，他会在选左和选右之间选择最好的
        // 所以经过玩家2选择后，留给玩家1的就是最小的
        int p1 = nums[l] + Math.min(f(nums, l + 2, r), f(nums, l + 1, r - 1));
        // 选右边，同理
        int p2 = nums[r] + Math.min(f(nums, l + 1, r - 1), f(nums, l, r - 2));
        return Math.max(p1, p2);
    }
}
