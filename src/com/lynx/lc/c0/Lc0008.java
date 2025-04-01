package com.lynx.lc.c0;

/**
 * 8. 字符串转换整数 (atoi)
 */
public class Lc0008 {
    public int myAtoi(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char[] arr = s.trim().toCharArray();
        int n = arr.length;
        int ans = 0, sign = 1, i = 1, cur;
        if (arr[0] == '-') {
            sign = -1;
        } else if (arr[0] != '+') {
            i = 0;
        }
        int limit1 = Integer.MAX_VALUE / 10;
        int limit2 = Integer.MAX_VALUE % 10;
        for ( ; i < n; i++) {
            if (arr[i] < '0' || arr[i] > '9') {
                break;
            }
            cur = arr[i] - '0';
            if (ans > limit1 || (ans == limit1 && cur > limit2)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + cur;
        }
        return sign * ans;
    }
}
