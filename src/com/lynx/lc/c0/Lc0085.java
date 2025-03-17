package com.lynx.lc.c0;

import java.util.Arrays;

/**
 * 85. 最大矩形
 *
 * @apiNote 压缩数组+单调栈
 */
public class Lc0085 {
    private int n;

    private final int[] height = new int[200];

    private final int[] stack = new int[200];

    public int maximalRectangle(char[][] matrix) {
        n = matrix[0].length;
        Arrays.fill(height, 0, n, 0);
        int ans = 0;
        for (char[] mat : matrix) {
            // 通过以每一行为底并压缩数组，来计算当前最大矩形的面积
            for (int i = 0; i < n; i++) {
                height[i] = mat[i] == '0' ? 0 : height[i] + 1;
            }
            ans = Math.max(ans, getMaxArea());
        }
        return ans;
    }

    private int getMaxArea() {
        int maxArea = 0;
        int size = 0, cur, left;
        for (int i = 0; i < n; i++) {
            while (size > 0 && height[i] <= height[stack[size - 1]]) {
                cur = stack[--size];
                left = size == 0 ? -1 : stack[size - 1];
                maxArea = Math.max(maxArea, height[cur] * (i - left - 1));
            }
            stack[size++] = i;
        }
        while (size > 0) {
            cur = stack[--size];
            left = size == 0 ? -1 : stack[size - 1];
            maxArea = Math.max(maxArea, height[cur] * (n - left - 1));
        }
        return maxArea;
    }
}
