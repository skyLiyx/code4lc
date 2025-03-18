package com.lynx.lc.c0;

/**
 * 69. x 的平方根
 */
public class Lc0069 {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int ans = 0;
        int l = 1, r = x, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if ((long)m * m <= x) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}
