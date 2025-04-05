package lyx.lc.c14;

import java.util.Arrays;
import java.util.List;

/**
 * 1434. 每个人戴不同帽子的方案数
 *
 * @apiNote 状压DP
 */
public class Lc1434 {
    private static final int MOD = (int)1e9 + 7;

    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size(); // 人数
        int m = 0; // 帽子最大值
        for (List<Integer> people: hats) {
            for (int hat : people) {
                m = Math.max(m, hat);
            }
        }
        int[] fits = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int hat : hats.get(i)) {
                fits[hat] |= 1 << i;
            }
        }
        int[][] dp = new int[m + 1][1 << n];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(n, m, fits, 1, 0, dp);
    }

    private int f(int n, int m, int[] fits, int curHat, int status, int[][] dp) {
        if (status == (1 << n) - 1) {
            return 1;
        }
        if (curHat == m + 1) {
            return 0;
        }
        if (dp[curHat][status] != -1) {
            return dp[curHat][status];
        }
        // 可能性1：不选当前帽子
        int ans = f(n, m, fits, curHat + 1, status, dp);
        // 可能性2：选择当前帽子分给其中一人
        int people = fits[curHat];
        int rightOne;
        while (people != 0) { // 在该帽子匹配的人中选择
            rightOne = people & (~people + 1);
            if ((status & rightOne) == 0) {
                ans = (ans + f(n, m, fits, curHat + 1, status | rightOne, dp)) % MOD;
            }
            people ^= rightOne;
        }
        dp[curHat][status] = ans;
        return dp[curHat][status];
    }
}
