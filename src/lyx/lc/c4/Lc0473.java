package lyx.lc.c4;

/**
 * 473. 火柴拼正方形
 *
 * @apiNote 状压DP
 */
public class Lc0473 {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int n = matchsticks.length;
        int[] dp = new int[1 << n];
        return f(matchsticks, sum / 4, 4, sum / 4, (1 << n) - 1, dp);
    }

    /**
     *
     * @param arr         长度数组
     * @param sideLimit   每条边的长度
     * @param sideCount   剩余的边数
     * @param curSideRest 当前边剩余的长度
     * @param status      数组中剩余可选下标
     * @param dp          缓存
     */
    private boolean f(int[] arr, int sideLimit, int sideCount, int curSideRest, int status, int[] dp) {
        if (sideCount == 0) {
            return status == 0; // 所有火柴都用光
        }
        if (dp[status] != 0) {
            return dp[status] == 1;
        }
        boolean ans = false;
        for (int i = 0; i < arr.length; i++) {
            if ((status & (1 << i)) != 0 && arr[i] <= curSideRest) {
                if (arr[i] == curSideRest) {
                    ans = f(arr, sideLimit, sideCount - 1, sideLimit, status ^ (1 << i), dp);
                } else {
                    ans = f(arr, sideLimit, sideCount, curSideRest - arr[i], status ^ (1 << i), dp);
                }
                if (ans) {
                    break;
                }
            }
        }
        dp[status] = ans ? 1 : -1;
        return ans;
    }
}
