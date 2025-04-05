package lyx.lc.c3;

/**
 * 326. 3的幂
 */
public class Lc0326 {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
