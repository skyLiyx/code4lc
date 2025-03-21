package com.lynx.lc.c3;

import java.util.Arrays;

/**
 * 342. 4的幂
 */
public class Lc0342 {
    public boolean isPowerOfFour(int n) {
        return Arrays.asList(
                1,
                4,
                16,
                64,
                256,
                1024,
                4096,
                16384,
                65536,
                262144,
                1048576,
                4194304,
                16777216,
                67108864,
                268435456,
                1073741824
        ).contains(n);
    }
}
