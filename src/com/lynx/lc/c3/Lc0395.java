package com.lynx.lc.c3;

import java.util.Arrays;

/**
 * 395. 至少有 K 个重复字符的最长子串
 *
 * @apiNote 滑动窗口
 */
public class Lc0395 {
    private final int[] cnt = new int[256];

    public int longestSubstring(String s, int k) {
        int ans = 0;
        // 通过分别计算字符种类从1到26的答案，构建滑动窗口的单调性关系
        for (int require = 1, kind, satisfy; require <= 26; require++) {
            // 已出现的字符种类数量
            kind = 0;
            // 数量达到k的字符种类数量
            satisfy = 0;
            // 初始化数量
            Arrays.fill(cnt, 0);
            for (int l = 0, r = 0, ch; r < s.length(); r++) {
                ch = s.charAt(r);
                if (cnt[ch]++ == 0) {
                    kind++;
                }
                if (cnt[ch] == k) {
                    satisfy++;
                }
                while (kind > require) {
                    ch = s.charAt(l);
                    if (cnt[ch]-- == k) {
                        satisfy--;
                    }
                    if (cnt[ch] == 0) {
                        kind--;
                    }
                    l++;
                }
                if (satisfy == require) {
                    ans = Math.max(ans, r - l + 1);
                }
            }
        }
        return ans;
    }
}
