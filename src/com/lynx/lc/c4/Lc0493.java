package com.lynx.lc.c4;

/**
 * 493.翻转对
 *
 * @apiNote 归并分治
 */
public class Lc0493 {
    public int reversePairs(int[] arr) {
        return dc(arr, 0, arr.length - 1);
    }

    public int dc(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = l + ((r - l) >> 1);
        return dc(arr, l, m) + dc(arr, m + 1, r) + merge(arr, l, m, r);
    }

    private int merge(int[] arr, int l, int m, int r) {
        int ans = 0, sum = 0;
        for (int i = l, j = m + 1; i <= m; i++) {
            while (j <= r && arr[i] > ((long)arr[j] << 1)) {
                sum++;
                j++;
            }
            ans += sum;
        }
        int[] help = new int[r - l + 1];
        int p1 = l, p2 = m + 1, i = 0;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int j = l; j <= r; j++) {
            arr[j] = help[j - l];
        }
        return ans;
    }
}
