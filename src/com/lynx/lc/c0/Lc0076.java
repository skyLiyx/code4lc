package com.lynx.lc.c0;

/**
 * 76. 最小覆盖子串
 *
 * @apiNote 滑动窗口
 */
public class Lc0076 {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return "";
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] map = new int[128];
        // 构造滑动窗口中缺失的字符以及数量
        for (int i = 0; i < n; i++) {
            map[ct[i]]--;
        }
        // 缺失的字符数量
        int debt = n;
        // 记录最大子串的起始位和长度
        int left = 0;
        int len = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < m; r++) {
            if (map[cs[r]]++ < 0) {
                debt--;
            }
            if (debt > 0) {
                continue;
            }
            // 此时debt == 0，即窗口中已包含所有目标字符
            while (map[cs[l]] > 0) {
                map[cs[l++]]--;
            }
            if (r - l + 1 < len) {
                len = r - l + 1;
                left = l;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(left, left + len);
    }
}
