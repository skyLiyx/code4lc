package com.lynx.lc.c12;

/**
 * 1299.将每个元素替换为右侧最大元素
 *
 * @date 2025/02/16
 */
public class Lc1299 {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max = arr[n - 1];
        arr[n - 1] = -1;
        // 倒序遍历，每次替换原值，顺便更新最大值
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                int temp = arr[i];
                arr[i] = max;
                max = temp;
            } else {
                arr[i] = max;
            }
        }
        return arr;
    }
}
