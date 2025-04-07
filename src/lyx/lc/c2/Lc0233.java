package lyx.lc.c2;

import java.util.Arrays;

/**
 * 233. 数字 1 的个数
 *
 * @apiNote 数位DP
 */
public class Lc0233 {
    public int countDigitOne(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int[][] dp = new int[digits.length][digits.length];
        for (int i = 0; i < digits.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(digits, 0, 0, true, dp);
    }

    /**
     * @param digits  上限值每一位的数字
     * @param i       当前位
     * @param cnt     之前位上1的个数
     * @param isLimit 当前位是否限制
     * @param dp      缓存
     */
    public int f(char[] digits, int i, int cnt, boolean isLimit, int[][] dp) {
        if (i == digits.length) {
            return cnt;
        }
        if (!isLimit && dp[i][cnt] > -1) {
            return dp[i][cnt];
        }
        int ans = 0;
        int up = isLimit ? digits[i] - '0' : 9;
        for (int j = 0; j <= up; j++) {
            ans += f(digits, i + 1, cnt + (j == 1 ? 1 : 0), isLimit && j == up, dp);
        }
        if (!isLimit) {
            dp[i][cnt] = ans;
        }
        return ans;
    }
}
