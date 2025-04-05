package lyx.lc.c0;

/**
 * 50.Pow(x, n)
 */
public class Lc0050 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n >> 1);
        return half * half * myPow(x, n % 2);
    }
}
