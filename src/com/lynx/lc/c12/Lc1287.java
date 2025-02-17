package com.lynx.lc.c12;

/**
 * 1287.有序数组中出现次数超过25%的元素
 *
 * @date 2025/02/17
 */
public class Lc1287 {
    public int findSpecialInteger(int[] arr) {
        int n = (arr.length >> 2) + 1;
        int p = 0;
        while (p + n - 1 < arr.length) {
            if (arr[p] == arr[p + n - 1]) {
                return arr[p];
            }
            p++;
        }
        return -1;
    }
}