package com.lynx.lc.c9;

import java.util.Arrays;

/**
 * 912.排序数组
 */
public class Lc0912 {
    private static final int MAXN = 50001;
    private static final int BASE = 10;
    private static final int[] COUNT = new int[BASE];
    private static final int[] HELP = new int[MAXN];

    public int[] sortArray(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int n = nums.length;
        int min = nums[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, nums[i]);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] -= min; // 将数组元素转换成非负数
            max = Math.max(max, nums[i]);
        }
        int bits = bits(max);
        radixSort(nums, n, bits);
        for (int i = 0; i < n; i++) {
            nums[i] += min; // 还原
        }
        return nums;
    }

    private int bits(int n) {
        int ans = 0;
        while (n != 0) {
            ans++;
            n /= 10;
        }
        return ans;
    }

    private void radixSort(int[] nums, int n, int bits) {
        for (int offset = 1; bits > 0; offset *= BASE, bits--) {
            Arrays.fill(COUNT, 0);
            for (int i = 0; i < n; i++) {
                COUNT[(nums[i] / offset) % BASE]++;
            }
            for (int i = 1; i < BASE; i++) {
                COUNT[i] += COUNT[i - 1];
            }
            for (int i = 0; i < n; i++) {
                HELP[--COUNT[(nums[i] / offset) % BASE]] = nums[i];
            }
            for (int i = 0; i < n; i++) {
                nums[i] = HELP[i];
            }
        }
    }
}
