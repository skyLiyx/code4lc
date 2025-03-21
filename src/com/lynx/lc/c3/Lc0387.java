package com.lynx.lc.c3;

import java.util.Arrays;

/**
 * 387. 字符串中的第一个唯一字符
 */
public class Lc0387 {
    public int firstUniqChar(String s) {
        // first[i]: 字符 i 第一次出现的位置
        int[] first = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0, j; i < s.length(); i++) {
            j = s.charAt(i) - 'a';
            if (first[j] == -1) {
                // 第一次出现
                first[j] = i;
            } else {
                // 重复出现
                first[j] = -2;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (first[i] > -1) {
                // 是唯一字符
                ans = Math.min(ans, first[i]);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
