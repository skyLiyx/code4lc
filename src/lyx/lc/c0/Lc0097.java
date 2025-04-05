package lyx.lc.c0;

/**
 * 97. 交错字符串
 */
public class Lc0097 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        int m = c1.length;
        int n = c2.length;
        // dp[i][j]: s1的前i个长度 + s2的前j个长度 是否等于 s3的前i+j个长度
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            if (c2[i - 1] != c3[i - 1]) {
                break;
            }
            dp[i] = true;
        }
        for (int i = 1; i <= m; i++) {
            dp[0] = dp[0] && c1[i - 1] == c3[i - 1];
            for (int j = 1; j <= n; j++) {
                // s3最后一个长度一定是s1或s2的
                dp[j] = (c1[i - 1] == c3[i + j - 1] && dp[j])
                        ||
                        (c2[j - 1] == c3[i + j - 1] && dp[j - 1]);
            }
        }
        return dp[n];
    }
}
