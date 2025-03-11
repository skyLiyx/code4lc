package com.lynx.lc.c0;

/**
 * 44.通配符匹配
 */
public class Lc0044 {
    public boolean isMatch(String s, String p) {
        if (s.isEmpty()) {
            return p.isEmpty() || allStars(p);
        }
        if (p.isEmpty()) {
            return false;
        }
        p = removeDupStars(p);
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        dp[m][n - 1] = p.charAt(n - 1) == '*';
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (p.charAt(j) == '?') {
                    dp[i][j] = dp[i + 1][j + 1];
                } else if (p.charAt(j) >= 'a' && p.charAt(j) <= 'z') {
                    dp[i][j] = s.charAt(i) == p.charAt(j) && dp[i + 1][j + 1];
                } else if (j == n - 1) {
                    dp[i][j] = true;
                } else {
                    int k = i;
                    while (k < s.length()) {
                        if (dp[k][j + 1]) {
                            dp[i][j] = true;
                            break;
                        }
                        k++;
                    }
                }
            }
        }
        return dp[0][0];
    }

    private boolean allStars(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    /**
     * 去除模式串中重复的星号。
     */
    private String removeDupStars(String p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && sb.length() != 0 && sb.charAt(sb.length() - 1) == '*') {
                continue;
            }
            sb.append(p.charAt(i));
        }
        return sb.toString();
    }

    public boolean isMatch_v1(String s, String p) {
        int i = 0, j = 0, iStar = -1, jStar = -1, m = s.length(), n = p.length();
        while (i < m) {
            if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < n && p.charAt(j) == '*') {
                // 记录遇到星号的位置
                iStar = i;
                jStar = j++;
            } else if (iStar >= 0) {
                // 不匹配，回到记录位置的下一个位置
                i = ++iStar;
                j = jStar + 1;
            } else {
                return false;
            }
        }
        while (j < n && p.charAt(j) == '*') {
            j++;
        }
        return j == n;
    }
}
