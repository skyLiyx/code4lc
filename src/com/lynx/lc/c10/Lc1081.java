package com.lynx.lc.c10;

import java.util.Arrays;

/**
 * 1081. 不同字符的最小子序列
 *
 * @apiNote 单调栈
 */
public class Lc1081 {
    private final char[] stack = new char[1000];
    private final int[] count = new int[26];
    private final boolean[] enter = new boolean[26];

    public String smallestSubsequence(String s) {
        Arrays.fill(count, 0);
        Arrays.fill(enter, false);
        char[] arr = s.toCharArray();
        for (char c : arr) {
            count[c - 'a']++;
        }
        int size = 0;
        for (char c : arr) {
            if (!enter[c - 'a']) {
                while (size > 0 && stack[size - 1] > c && count[stack[size - 1] - 'a'] > 0) {
                    enter[stack[--size] - 'a'] = false;
                }
                stack[size++] = c;
                enter[c - 'a'] = true;
            }
            count[c - 'a']--;
        }
        return String.valueOf(stack, 0, size);
    }
}
