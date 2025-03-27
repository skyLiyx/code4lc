package com.lynx.lc.c0;

import com.lynx.algo.string.Manacher;

/**
 * 5.最长回文子串
 *
 * @see Manacher
 */
public class Lc0005 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        return longestPalindrome_c(s);
    }

    /**
     * Manacher算法
     */
    private String longestPalindrome_manacher(String s) {
        return Manacher.longestPalindrome(s);
    }

    /**
     * 动态规划
     */
    private String longestPalindrome_dp(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        // dp[i][j]: 从i到j是否回文串
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int max = 1;
        for (int r = 1; r < n; r++) {
            for (int l = 0; l < r; l++) {
                if (ch[l] == ch[r] && (l + 1 >= r - 1 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > max) {
                        start = l;
                        max = r - l + 1;
                    }
                }
            }
        }
        return s.substring(start, start + max);
    }

    /**
     * 中心扩展。
     */
    private String longestPalindrome_c(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int max = 1;
        int start = 0;
        for (int i = 0, l, r; i < n - 1; i++) {
            for (int j = 0; j < 2; j++) { // 奇数回文和偶数回文
                l = i;
                r = i + j;
                while (l >= 0 && r < n && ch[l] == ch[r]) {
                    l--;
                    r++;
                }
                l++;
                r--;
                if (r - l + 1 > max) {
                    max = r - l + 1;
                    start = l;
                }
            }
        }
        return s.substring(start, start + max);
    }
}
