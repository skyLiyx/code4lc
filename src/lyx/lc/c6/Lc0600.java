package lyx.lc.c6;

/**
 * 600. 不含连续1的非负整数
 *
 * @apiNote 数位DP
 */
public class Lc0600 {
    public int findIntegers(int n) {
        String binaryString = Integer.toBinaryString(n);
        int[][] dp = new int[binaryString.length()][2];
        for (int i = 0; i < binaryString.length(); i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return f(binaryString.toCharArray(), 0, 0, true, dp);
    }

    private int f(char[] b, int i, int pre, boolean isLimit, int[][] dp) {
        if (i == b.length) {
            return 1;
        }
        if (!isLimit && dp[i][pre] != -1) {
            return dp[i][pre];
        }
        int ans = 0;
        if (pre == 1) {
            // 前一位选择了1，当前只能选择0
            ans += f(b, i + 1, 0, isLimit && b[i] == '0', dp);
        } else if (isLimit) {
            // 没有连续1的限制，但是有大小限制
             if (b[i] == '0') {
                 ans += f(b, i + 1, 0, true, dp);
             } else {
                 ans += f(b, i + 1, 0, false, dp)
                         + f(b, i + 1, 1, true, dp);
             }
        } else {
            // 当前没有连续1的限制，也没有大小限制
            ans += f(b, i + 1, 0, false, dp)
                    + f(b, i + 1, 1, false, dp);
        }
        dp[i][pre] = ans;
        return ans;
    }

}
