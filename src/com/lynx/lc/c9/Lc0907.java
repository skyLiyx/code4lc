package com.lynx.lc.c9;

/**
 * 907. 子数组的最小值之和
 *
 * @apiNote 单调栈
 */
public class Lc0907 {
    private static final int MOD = (int)1e9 + 7;

    private final int[] stack = new int[30000];

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long ans = 0;
        int size = 0, cur, left;
        for (int i = 0; i < n; i++) {
            while (size > 0 && arr[i] <= arr[stack[size - 1]]) {
                cur = stack[--size];
                left = size > 0 ? stack[size - 1] : -1;
                // 此时可以理解成[left,i)范围内的子数组的最小值都是arr[cur]
                ans = (ans + (long)arr[cur] * (cur - left) * (i - cur)) % MOD;
            }
            stack[size++] = i;
        }
        while (size > 0) {
            cur = stack[--size];
            left = size > 0 ? stack[size - 1] : -1;
            ans = (ans + (long)arr[cur] * (cur - left) * (n - cur)) % MOD;
        }
        return (int)ans;
    }
}
