package com.lynx.lc.c0;

/**
 * 91. 解码方法
 */
public class Lc0091 {
    public int numDecodings(String s) {
        int next = 1;
        int nextNext = 0;
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1, cur; i >= 0; i--) {
            if (arr[i] == '0') {
                cur = 0;
            } else {
                cur = next;
                if (i + 1 < arr.length && (arr[i] - '0') * 10 + (arr[i + 1] - '0') <= 26) {
                    cur += nextNext;
                }
            }
            nextNext = next;
            next = cur;
        }
        return next;
    }
}
