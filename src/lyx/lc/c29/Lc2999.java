package lyx.lc.c29;

import java.util.Arrays;

/**
 * 2999. 统计强大整数的数目
 *
 * @date 2025/04/10
 */
public class Lc2999 {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String s1 = String.valueOf(start - 1);
        String s2 = String.valueOf(finish);
        long[] dp = new long[s2.length()];
        long num1 = 0;
        if (start > Long.parseLong(s)) {
            Arrays.fill(dp, -1);
            num1 = f(s1, s, limit, 0, true, false, dp);
        }
        Arrays.fill(dp, -1);
        long num2 = f(s2, s, limit, 0, true, false, dp);
        return num2 - num1;
    }

    private long f(String digits, String suffix, int limit, int i, boolean isLimit, boolean isNum, long[] dp) {
        if (i == digits.length() - suffix.length()) {
            if (isNum) {
                return isLimit && suffix.compareTo(digits.substring(i)) > 0 ? 0 : 1;
            } else {
                return Long.parseLong(suffix) <= Long.parseLong(digits) ? 1 : 0;
            }
        }
        if (!isLimit && isNum && dp[i] != -1) {
            return dp[i];
        }
        long ans = 0;
        if (!isNum) {
            ans += f(digits, suffix, limit, i + 1, false, false, dp);
        }
        int low = isNum ? 0 : 1;
        int high = isLimit ? Math.min(limit, digits.charAt(i) - '0') : limit;
        for (int j = low; j <= high; j++) {
            ans += f(digits, suffix, limit, i + 1, isLimit && j == digits.charAt(i) - '0', true, dp);
        }
        if (!isLimit && isNum) {
            dp[i] = ans;
        }
        return ans;
    }
}
