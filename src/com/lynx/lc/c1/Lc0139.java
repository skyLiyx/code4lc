package com.lynx.lc.c1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 */
public class Lc0139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();
        // dp[i]: 从0开始，i长度的子串可以被拼接成
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int r = 1; r <= n; r++) {
            for (int l = r - 1; l >= 0; l--) {
                if (dp[l] && words.contains(s.substring(l, r))) {
                    dp[r] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
