package lyx.lc.c19;

/**
 * 1922. 统计好数字的数目
 *
 * @date 2025/04/13
 */
public class Lc1922 {
    private static final long MOD = (long) 1e9 + 7;

    public int countGoodNumbers(long n) {
        // 偶数位的个数
        long evenDigitCount = (n + 1) >> 1;
        // 奇数位的个数
        long oddDigitCount = n >> 1;
        // 组合数学
        return (int) (pow(5, evenDigitCount) * pow(4, oddDigitCount) % MOD);
    }

    private long pow(long x, long n) {
        long ans = 1L;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = (ans * x) % MOD;
            }
            x = (x * x) % MOD;
            n >>= 1;
        }
        return ans;
    }
}
