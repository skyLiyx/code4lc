package lyx.lc.c28;

/**
 * 2829. k-avoiding 数组的最小总和
 *
 * @date 2025/03/26
 */
public class Lc2829 {
    public int minimumSum(int n, int k) {
        if (k > n + n - 1) {
            return sum(n);
        }
        // 从k/2开始到k-1的数不能要，后面补充这个数量的数字
        n += (k - 1) / 2;
        // 前(n+(k-1)/2)项前缀和 - 前k-1项前缀和 + 前k/2项前缀和
        return sum(n) - sum(k - 1) + sum(k / 2);
    }

    private int sum(int n) {
        // 1~n的累加和
        return (n * (n + 1)) >> 1;
    }
}
