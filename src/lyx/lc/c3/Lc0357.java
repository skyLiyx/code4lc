package lyx.lc.c3;

/**
 * 357. 统计各位数字都不同的数字个数
 */
public class Lc0357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int ans = 10;
        for (int i = 9, j = 9, k = 2; k <= n; j--, k++) {
            i *= j;
            ans += i;
        }
        return ans;
    }
}
