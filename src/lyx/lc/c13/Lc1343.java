package lyx.lc.c13;

/**
 * 1343. 大小为 K 且平均值大于等于阈值的子数组数目
 */
public class Lc1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int t = k * threshold;
        int sum = 0;
        for (int i = 0; i < k - 1; i++) {
            sum += arr[i];
        }
        int ans = 0;
        for (int i = k - 1; i < arr.length; i++) {
            sum += arr[i];
            if (sum >= t) {
                ans++;
            }
            sum -= arr[i - k + 1];
        }
        return ans;
    }
}
