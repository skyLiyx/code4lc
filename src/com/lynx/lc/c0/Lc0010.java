package com.lynx.lc.c0;

/**
 * 10.正则表达式匹配
 *
 * @apiNote
 * 用两个指针 i, j 分别指向字符串 s 开头和模式串 p 开头, 根据匹配情况向后移动
 * <pre>
 * - 如果 j+1 指向字符不是 '*'
 *   两个指针指向的字符就必须相同，要么是两个相同的字符，要么p对应的是 '.'.
 *
 * - 如果 j+1 指向字符是 '*'
 *   j 和 j+1 组成 '_*' 作为整体考虑, 分两种情况：
 *   - 匹配0个 s 中的字符，指针 i 不移动, j 右移2
 *   - 匹配1个 s 中的字符，指针 i 右移1, j 不移动
 *
 * - 如果 i 越界
 *   - j 也越界, 说明整体匹配成功
 *   - j 没越界, 如果 j+1 也没越界且是 '*', 可以消除掉 j 和 j+1, 后续继续比较
 *
 * - 如果 j 越界, 但是 i 没越界, 匹配失败
 * </pre>
 */
public class Lc0010 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        char[] c1 = s.toCharArray();
        char[] c2 = p.toCharArray();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        for (int j = n - 2; j >= 0; j--) {
            dp[m][j] = c2[j + 1] == '*' && dp[m][j + 2];
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j + 1 == n || c2[j + 1] != '*') {
                    dp[i][j] = (c1[i] == c2[j] || c2[j] == '.') && dp[i + 1][j + 1];
                } else {
                    dp[i][j] = dp[i][j + 2] || ((c1[i] == c2[j] || c2[j] == '.') && dp[i + 1][j]);
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
            // s匹配完了
            if (j == p.length) {
                // p也匹配完了
                return true;
            } else {
                // p还剩一些后缀
                // 后续的_*可以被消灭掉
                return j + 1 < p.length && p[j + 1] == '*' && f(s, i, p, j + 2);
            }
        } else if (j == p.length) {
            // s没匹配完，p匹配完了
            return false;
        } else {
            // s和p都没匹配完
            if (j + 1 == p.length || p[j + 1] != '*') {
                // p后面第二个不是 '*'
                // 那么必须单独匹配这一个字符
                return (s[i] == p[j] || p[j] == '.') && f(s, i + 1, p, j + 1);
            } else {
                // p后面第二个是 '*'
                // 要么跳过这个 _*
                boolean p1 = f(s, i, p, j + 2);
                // 要么不跳过，匹配一个s
                boolean p2 = (s[i] == p[j] || p[j] == '.') && f(s, i + 1, p, j);
                return p1 || p2;
            }
        }
    }
}
