package lyx.lc.c11;

/**
 * 1137.第N个泰波那契数
 */
public class Lc1137 {
    public int tribonacci(int n) {
        if (n < 2) return n;
        if (n == 2) return 1;
        int pre1 = 1, pre2 = 1, pre3 = 0;
        for (int i = 3; i <= n; i++) {
            int cur = pre1 + pre2 + pre3;
            pre3 = pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
