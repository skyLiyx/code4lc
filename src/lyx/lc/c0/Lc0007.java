package lyx.lc.c0;

/**
 * 7. 整数反转
 */
public class Lc0007 {
    public int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return (int)ans == ans ? (int)ans : 0;
    }
}
