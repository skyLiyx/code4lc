package com.lynx.lc.c0;

/**
 * 84. 柱状图中最大的矩形
 *
 * @apiNote 单调栈
 */
public class Lc0084 {
    private final int[] stack = new int[100000];

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = 0;
        int size = 0, cur, left;
        for (int i = 0; i < n; i++) {
            while (size > 0 && heights[i] <= heights[stack[size - 1]]) {
                cur = stack[--size];
                left = size > 0 ? stack[size - 1] : -1;
                ans = Math.max(ans, heights[cur] * (i - left - 1));
            }
            stack[size++] = i;
        }
        while (size > 0) {
            cur = stack[--size];
            left = size > 0 ? stack[size - 1] : -1;
            ans = Math.max(ans, heights[cur] * (n - left - 1));
        }
        return ans;
    }
}
