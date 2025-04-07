package lyx.lc.c9;

import java.util.Arrays;

/**
 * 902. 最大为 N 的数字组合
 *
 * @apiNote 数位DP
 */
public class Lc0902 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        char[] digit = new char[digits.length];
        for (int i = 0; i < digits.length; i++) {
            digit[i] = digits[i].charAt(0);
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return f(digit, s, 0, true, false, dp);
    }

    /**
     *
     * @param digits  可选数字
     * @param s       上限值
     * @param i       当前位
     * @param isLimit 当前位是否限制
     * @param isNum   是否数字，之前的位不生成时就不是数字
     */
    public int f(char[] digits, String s, int i, boolean isLimit, boolean isNum, int[] dp) {
        if (i == s.length()) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && dp[i] > -1) {
            return dp[i];
        }
        int ans = 0;
        if (!isNum) {
            ans += f(digits, s, i + 1, false, false, dp);
        }
        if (isLimit) {
            for (char digit : digits) {
                if (digit > s.charAt(i)) {
                    break;
                }
                ans += f(digits, s, i + 1, digit == s.charAt(i), true, dp);
            }
        } else {
            ans += digits.length * f(digits, s, i + 1, false, true, dp);
        }
        if (!isLimit && isNum) {
            dp[i] = ans;
        }
        return ans;
    }
}
