package com.lynx.lc.c3;

import java.util.Arrays;

/**
 * 316. 去除重复字母
 *
 * @apiNote 单调栈
 */
public class Lc0316 {

    private final char[] stack = new char[26];

    private final int[] count = new int[26];

    private final boolean[] enter = new boolean[26];

    public String removeDuplicateLetters(String s) {
        Arrays.fill(count, 0);
        Arrays.fill(enter, false);
        char[] arr = s.toCharArray();
        for (char c : arr) {
            count[c - 'a']++;
        }
        int size = 0;
        for (char c : arr) {
            if (!enter[c - 'a']) {
                while (size > 0 && c < stack[size - 1] && count[stack[size - 1] - 'a'] > 0) {
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
