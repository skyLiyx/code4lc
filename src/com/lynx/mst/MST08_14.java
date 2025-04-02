package com.lynx.mst;

/**
 * 面试题 08.14. 布尔运算
 */
public class MST08_14 {
    public int countEval(String s, int result) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[][][] dp = new int[n][n][]; // 不初始化，表示没计算过
        return f(ch, 0, ch.length - 1, dp)[result];
    }

    private int[] f(char[] s, int l, int r, int[][][] dp) {
        if (dp[l][r] != null) {
            return dp[l][r];
        }
        int f = 0; // 为false的数量
        int t = 0; // 为true的数量
        if (l == r) {
            f = 0 == s[l] - '0' ? 1 : 0;
            t = 1 == s[l] - '0' ? 1 : 0;
        } else {
            int[] temp;
            // 枚举每个逻辑符号作为最后运算的结果
            for (int i = l + 1, a, b, c, d; i < r; i += 2) {
                temp = f(s, l, i - 1, dp);
                a = temp[0];
                b = temp[1];
                temp = f(s, i + 1, r, dp);
                c = temp[0];
                d = temp[1];
                if (s[i] == '&') {
                    f += a * c + a * d + b * c;
                    t += b * d;
                } else if (s[i] == '|') {
                    f += a * c;
                    t += a * d + b * c + b * d;
                } else {
                    f += a * c + b * d;
                    t += a * d + c * b;
                }
            }
        }
        dp[l][r] = new int[]{f, t};
        return dp[l][r];
    }
}
