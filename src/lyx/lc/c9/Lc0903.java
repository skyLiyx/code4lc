package lyx.lc.c9;

/**
 * 903. DI 序列的有效排列
 */
public class Lc0903 {
    private static final int MOD = (int)1e9 + 7;

    public int numPermsDISequence(String s) {
        char[] arr = s.toCharArray();
        int n = s.length() + 1;
        int[][] dp = new int[n + 1][n + 1];
        for (int less = 0; less <= n; less++) {
            dp[n][less] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == 0 || arr[i - 1] == 'D') {
                dp[i][1] = dp[i + 1][0];
                for (int less = 2; less <= n; less++) {
                    dp[i][less] = (dp[i][less - 1] + dp[i + 1][less - 1]) % MOD;
                }
            } else {
                dp[i][n - i - 1] = dp[i + 1][n - i - 1];
                for (int less = n - i - 2; less >= 0; less--) {
                    dp[i][less] = (dp[i][less + 1] + dp[i + 1][less]) % MOD;
                }
            }
        }
        return dp[0][n];
    }

    public int numPermsDISequence1(String s) {
        return f(s.toCharArray(), 0, s.length() + 1, s.length() + 1);
    }

    /**
     * 暴力递归版本.
     *
     * @param s    字符序列
     * @param i    当前位置
     * @param less 比当前位置小的数量
     * @param n    总数量
     */
    public int f(char[] s, int i, int less, int n) {
        int ans = 0;
        if (i == n) {
            ans = 1;
        } else if (i == 0 || s[i - 1] == 'D') {
            // 来到0，默认前一个是无穷大，走 D 下降规则
            // 在比当前小的数中枚举，所以总共是less中排列情况
            for (int nextLess = 0; nextLess < less; nextLess++) {
                ans += f(s, i + 1, nextLess, n);
            }
        } else {
            // 走 I 上升规则
            // 在比当前大的数中枚举，比当前数大的数量k就是
            // 总数量n - 已经用过的i - 比当前小的less
            // 而比当前小的就是从less ~ less+k-1
            for (int nextLess = less, k = 1; k <= n - i - less; nextLess++, k++) {
                ans += f(s, i + 1, nextLess, n);
            }
        }
        return ans;
    }
}
