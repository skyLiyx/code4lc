package com.lynx.lc.c0;

/**
 * 10.正则表达式匹配
 *
 * @apiNote
 * <b>case 1</b>: {@code p.charAt(j) == s.charAt(i)}
 * <pre>
 *     ######a(i)
 *     ####a(j)
 *  </pre>
 * <b>case 2</b>: if {@code p.charAt(j) == '.'}
 * <pre>
 *     #######a(i)
 *     ####.(j)
 *  </pre>
 * <b>case 3</b>: if {@code p.charAt(j) == '*'}<p>
 * 3.1 if {@code p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i)},
 * then b* is counted as empty.
 * <pre>
 *     #####a(i)
 *     ####b*(j)
 * </pre>
 * 3.2 if {@code p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)}:
 * <pre>
 *     ######a(i)
 *     ####.*(j)
 *
 *     #####a(i)
 *     ###a*(j)
 * </pre>
 * there are also 3 cases:</br>
 *     - if {@code p.charAt(j - 1)} is counted as empty, then {@code dp[i][j] = dp[i][j - 2]}</br>
 *     - if counted as one, then {@code dp[i][j] = dp[i - 1][j - 2]}</br>
 *     - if counted as multiple, then {@code dp[i][j] = dp[i - 1][j]}</br>
 *
 */
public class Lc0010 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) != '.' && p.charAt(j - 2) != s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
