package lyx.lc.c0;

/**
 * 45. 跳跃游戏 II
 */
public class Lc0045 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= n - 1) {
                dp[i] = 1;
            } else {
                dp[i] = n;
                for (int j = i + 1; j <= i + nums[i]; j++) {
                    if (dp[j] != 0) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[0];
    }
}
