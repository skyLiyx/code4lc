package com.lynx.lc.c0;

/**
 * 29.两数相除
 */
public class Lc0029 {
    private static final int MIN = Integer.MIN_VALUE;

    public int divide(int dividend, int divisor) {
        if (dividend == MIN && divisor == MIN) {
            return 1;
        } else if (dividend != MIN && divisor != MIN) {
            return div(dividend, divisor);
        } else if (divisor == MIN) {
            return 0;
        } else {
            if (divisor < 0) {
                dividend = minus(dividend, divisor);
                return div(dividend, divisor) + 1;
            } else {
                dividend = plus(dividend, divisor);
                return div(dividend, divisor) - 1;
            }
        }
    }

    private int div(int a, int b) {
        int x = a < 0 ? plus(~a, 1) : a;
        int y = b < 0 ? plus(~b, 1) : b;
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            if ((x >> i) >= y) {
                ans |= 1 << i;
                x = minus(x, y << i);
            }
        }
        return a < 0 ^ b < 0 ? plus(~ans, 1) : ans;
    }

    /**
     * 二进制加法。
     */
    public int plus(int a, int b) {
        int ans = a;
        while (b != 0) {
            ans = a ^ b; // 无进位相加
            b = (a & b) << 1; // 统计进位
            a = ans; // 然后循环执行，直到没有进位为止
        }
        return ans;
    }

    public int minus(int a, int b) {
        // a - b = a + (-b)
        return plus(a, plus(~b, 1));
    }

    public int multiply(int a, int b) {
        int ans = 0;
        // 和十进制相乘原理一样，计算每一位的值，遇1就加a，遇0就不加
        // 从低位到高位，结果每次都左移一位，而b右移一位
        while (b != 0) {
            if ((b & 1) == 1) {
                ans = plus(ans, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return ans;
    }
}
