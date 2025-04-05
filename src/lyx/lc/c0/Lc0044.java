package lyx.lc.c0;

/**
 * 44.通配符匹配
 *
 * @see Lc0010
 */
public class Lc0044 {
    public boolean isMatch(String s, String p) {
        if (allStars(p.toCharArray())) {
            return true;
        }
        p = removeDuplicateStars(p.toCharArray());
        return isMatch(s.toCharArray(), p.toCharArray());
    }

    private boolean isMatch(char[] s, char[] p) {
        int m = s.length;
        int n = p.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        for (int j = n - 1; j >= 0; j--) {
            dp[m][j] = p[j] == '*' && dp[m][j + 1];
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (p[j] != '*') {
                    dp[i][j] = (p[j] == '?' || s[i] == p[j]) && dp[i + 1][j + 1];
                } else {
                    dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    /**
     * 暴力递归版本
     */
    private boolean f(char[] s, int i, char[] p, int j) {
        if (i == s.length) {
            if (j == p.length) {
                return true;
            } else {
                return p[j] == '*' && f(s, i, p, j + 1);
            }
        } else if (j == p.length) {
            return false;
        } else {
            if (p[j] != '*') {
                return (p[j] == '?' || s[i] == p[j]) && f(s, i + 1, p, j + 1);
            } else {
                return f(s, i, p, j + 1) || f(s, i + 1, p, j);
            }
        }
    }

    private boolean allStars(char[] p) {
        for (char c : p) {
            if (c != '*') {
                return false;
            }
        }
        return p.length != 0;
    }

    /**
     * 去除模式串中重复的星号。
     */
    private String removeDuplicateStars(char[] p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.length; i++) {
            if (p[i] == '*' && i - 1 >= 0 && p[i - 1] == '*') {
                continue;
            }
            sb.append(p[i]);
        }
        return sb.toString();
    }

    public boolean isMatch1(String s, String p) {
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
