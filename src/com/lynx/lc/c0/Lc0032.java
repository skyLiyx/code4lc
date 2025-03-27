package com.lynx.lc.c0;

/**
 * 32. 最长有效括号
 */
public class Lc0032 {
    public int longestValidParentheses(String s) {
        char[] ch = s.toCharArray();
        // dp[i]: 以i结尾能匹配的最长有效子串
        int[] dp = new int[ch.length + 1];
        int ans = 0;
        for (int i = 1, p; i < ch.length; i++) {
            if (ch[i] == ')') {
                p = i - dp[i - 1] - 1;
                if (p >= 0 && ch[p] == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (p > 0) {
                        dp[i] += dp[p - 1];
                    }
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }
}
