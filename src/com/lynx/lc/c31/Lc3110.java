package com.lynx.lc.c31;

/**
 * 3110. 字符串的分数
 *
 * @date 2025/03/15
 */
public class Lc3110 {
    public int scoreOfString(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            ans += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }
        return ans;
    }
}
