package lyx.lc.c8;

import lyx.lc.c4.Lc0486;

/**
 * 877. 石子游戏
 *
 * @see Lc0486
 */
public class Lc0877 {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // dp[i][j]: 先手玩家在[i,j]范围内能获得的最大分数
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = piles[i];
            if (i + 1 < n) {
                dp[i][i + 1] = Math.max(piles[i], piles[i + 1]);
            }
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = Math.max(
                        piles[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
                        piles[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
            }
        }
        int sum = 0;
        for (int p : piles) {
            sum += p;
        }
        int player1 = dp[0][n - 1];
        int player2 = sum - player1;
        return player1 >= player2;
    }
}
