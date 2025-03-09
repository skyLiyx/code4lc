package com.lynx.lc.c3;

/**
 * 371.两整数之和
 */
public class Lc0371 {
    public int getSum(int a, int b) {
        int ans = a;
        while (b != 0) {
            ans = a ^ b;
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }
}
