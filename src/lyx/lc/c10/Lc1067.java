package lyx.lc.c10;

import java.util.Arrays;

/**
 * 1067. 范围内的数字计数
 *
 * @apiNote 数位DP
 */
public class Lc1067 {
    public int digitsCount(int d, int low, int high) {
        char[] lowDigits = String.valueOf(low - 1).toCharArray();
        char[] highDigits = String.valueOf(high).toCharArray();
        int[][] dp = new int[highDigits.length][highDigits.length + 1];
        for (int i = 0; i < highDigits.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int h = f(highDigits, d, 0, 0, true, false, dp);
        for (int i = 0; i < lowDigits.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int l = f(lowDigits, d, 0, 0, true, false, dp);
        return h - l;
    }

    public int f(char[] digits, int d, int i, int count, boolean isLimit, boolean isNum, int[][] dp) {
        if (i == digits.length) {
            return isNum ? count : 0;
        }
        if (!isLimit && isNum && dp[i][count] != -1) {
            return dp[i][count];
        }
        int ans = 0;
        if (!isNum) {
            ans += f(digits, d, i + 1, count, false, false, dp);
        }
        int low = isNum ? 0 : 1;
        int up = isLimit ? digits[i] - '0' : 9;
        for (int j = low; j <= up; j++) {
            ans += f(digits, d, i + 1, count + (j == d ? 1 : 0), isLimit && j == up, true, dp);
        }
        if (!isLimit && isNum) {
            dp[i][count] = ans;
        }
        return ans;
    }
}
