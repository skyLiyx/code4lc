package lyx.lc.c25;

/**
 * 2595.奇偶位数
 *
 * @date 2025/02/20
 */
public class Lc2595 {
    // 01010101... 偶数位掩码
    private static final int EVEN_MASK = 0x55555555;

    // 10101010... 奇数位掩码
    private static final int ODD_MASK = 0xAAAAAAAA;

    public int[] evenOddBit(int n) {
        int even = Integer.bitCount(n & EVEN_MASK); // 消除奇数位后计数
        int odd = Integer.bitCount(n & ODD_MASK); // 消除偶数位后计数
        return new int[]{even, odd};
    }
}
