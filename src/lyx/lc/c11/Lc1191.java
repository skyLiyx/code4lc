package lyx.lc.c11;

/**
 * 1191. K 次串联后最大子数组之和
 */
public class Lc1191 {
    private static final long MOD = (long) 1e9 + 7;

    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        long sum = 0, maxSum = 0, prefixSum = 0, maxPrefix = 0, suffixSum = 0, maxSuffix = 0;
        for (int i = 0; i < n; i++) {
            sum = Math.max(sum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, sum);
            prefixSum += arr[i];
            maxPrefix = Math.max(maxPrefix, prefixSum);
            suffixSum += arr[n - 1 - i];
            maxSuffix = Math.max(maxSuffix, suffixSum);
        }
        if (maxSum == 0) {
            return 0;
        }
        if (k == 1) {
            return (int) (maxSum % MOD);
        }
        // 两段相接，或整个数组和不大于0
        // 要么是最大前缀和+最大后缀和，要么是最大子数组和
        if (k == 2 || prefixSum <= 0) {
            return (int) (Math.max(maxSum, maxSuffix + maxPrefix) % MOD);
        }
        // 多个数组相接，且数组和大于0
        // 第一段的最大后缀和 + 最后一段的最大前缀和 + 中间剩余段的总和
        return (int) ((maxSuffix + maxPrefix + (k - 2) * prefixSum % MOD) % MOD);
    }
}
