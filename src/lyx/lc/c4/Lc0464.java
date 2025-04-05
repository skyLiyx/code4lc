package lyx.lc.c4;

/**
 * 464. 我能赢吗
 *
 * @apiNote 状压DP
 */
public class Lc0464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        int[] dp = new int[1 << (maxChoosableInteger + 1)];
        return f(maxChoosableInteger, desiredTotal, (1 << (maxChoosableInteger + 1)) - 1, dp);
    }

    /**
     *
     * @param n      整数范围[1,n]
     * @param target 目标和
     * @param rest   剩余可选数字，n+1位二进制，每一位表示对应的值是否可选，为1表示可选，为0表示不可选
     * @param dp     当前选择情况的缓存
     */
    private boolean f(int n, int target, int rest, int[] dp) {
        if (target <= 0) {
            return false;
        }
        if (dp[rest] != 0) {
            return dp[rest] == 1;
        }
        boolean ans = false;
        for (int i = 1; i <= n; i++) {
            if ((rest & (1 << i)) != 0 && !f(n, target - i, rest ^ (1 << i), dp)) {
                ans = true;
                break;
            }
        }
        dp[rest] = ans ? 1 : -1;
        return ans;
    }
}
