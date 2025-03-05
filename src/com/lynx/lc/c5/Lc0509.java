package com.lynx.lc.c5;

/**
 * 509.斐波那契数
 */
public class Lc0509 {
    public int fib(int n) {
        int pre2 = 0,  pre1 = 1;
        for (int i = 1; i <= n; i++) {
            int temp = pre1;
            pre1 = pre1 + pre2;
            pre2 = temp;
        }
        return pre2;
    }
}
