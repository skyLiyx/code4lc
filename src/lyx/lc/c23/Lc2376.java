package lyx.lc.c23;

import java.util.Arrays;

/**
 * 2376. 统计特殊整数
 *
 * @apiNote 数位DP
 */
public class Lc2376 {
    public int countSpecialNumbers(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int[][] dp = new int[digits.length][1 << 10];
        for (int i = 0; i < digits.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(digits, 0, 0, true, false, dp);
    }

    /**
     * @param digits  上限值每一位的数字
     * @param i       当前位
     * @param mask    用过的数字
     * @param isLimit 当前位是否限制
     * @param isNum   是否数字，之前的位不生成时就不是数字
     * @param dp      缓存
     */
    public int f(char[] digits, int i, int mask, boolean isLimit, boolean isNum, int[][] dp) {
        if (i == digits.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && dp[i][mask] > -1) {
            return dp[i][mask];
        }
        int ans = 0;
        if (!isNum) {
            ans += f(digits, i + 1, mask, false, false, dp);
        }
        int low = isNum ? 0 : 1;
        int up = isLimit ? digits[i] - '0' : 9;
        for (int j = low; j <= up; j++) {
            if ((mask & (1 << j)) == 0) {
                ans += f(digits, i + 1, mask | (1 << j), isLimit && j == up, true, dp);
            }
        }
        if (!isLimit && isNum) {
            dp[i][mask] = ans;
        }
        return ans;
    }
}
