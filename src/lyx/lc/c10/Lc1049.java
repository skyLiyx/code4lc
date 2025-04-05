package lyx.lc.c10;

/**
 * 1049. 最后一块石头的重量 II
 */
public class Lc1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        // 问题本质就是将数组分为两个集合，要求两个集合的累加和的差值尽量小
        // 在数组中找出累加和小于等于sum/2，但尽量接近的子序列
        int near = near(stones, sum / 2);
        return sum - near - near;
    }

    private int near(int[] stones, int target) {
        // dp[i][j]: 前i个数中累加和<=target的最大子序列
        int[] dp = new int[target + 1];
        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                // 不取，就是上一层的对应值
                // 取，就是上一层中前面j-stones[i]的值加上当前值
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }
        return dp[target];
    }
}
