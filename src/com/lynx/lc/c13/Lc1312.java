package com.lynx.lc.c13;

/**
 * 1312. 让字符串成为回文串的最少插入次数
 */
public class Lc1312 {
    public int minInsertions(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = n - 2, leftDown, backup; i >= 0; i--) {
            // dp[i] = 0;
            leftDown = dp[i + 1];
            if (arr[i] != arr[i + 1]) {
                dp[i + 1] = 1;
            }
            for (int j = i + 2; j < n; j++) {
                backup = dp[j];
                if (arr[i] == arr[j]) {
                    dp[j] = leftDown;
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + 1;
                }
                leftDown = backup;
            }
        }
        return dp[n - 1];
    }

    /**
     * 暴力递归.
     */
    private int f(char[] s, int l, int r) {
        if (l == r) {
            return 0;
        }
        if (l + 1 == r) {
            return s[l] == s[r] ? 0 : 1;
        }
        // 两个以上字符
        if (s[l] == s[r]) {
            // 两边的相等
            return f(s, l + 1, r - 1);
        }
        // 两边的不等，在右边加一个左边字符 pk 在左边加一个右边字符
        return Math.min(f(s, l + 1, r), f(s, l, r - 1)) + 1;
    }
}
