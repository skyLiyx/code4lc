package lyx.lc.c15;

import java.util.Arrays;

/**
 * 1504. 统计全 1 子矩形
 *
 * @apiNote 压缩数组+单调栈
 */
public class Lc1504 {
    private final int[] stack = new int[150];

    private final int[] height = new int[150];

    public int numSubmat(int[][] mat) {
        int n = mat[0].length;
        Arrays.fill(height, 0, n, 0);
        int ans = 0;
        for (int[] m : mat) {
            // 压缩数组
            for (int i = 0; i < n; i++) {
                height[i] = m[i] == 0 ? 0 : height[i] + 1;
            }
            int size = 0, cur, left, len, bottom;
            for (int i = 0; i < n; i++) {
                while (size > 0 && height[i] <= height[stack[size - 1]]) {
                    // 每找到一个左右两边的较小值，就可以计算以当前值为最大高度，两个较小值中的较大值为最小高度的矩形的数量
                    cur = stack[--size]; // 当前高度
                    left = size == 0 ? -1 : stack[size - 1];
                    len = i - left - 1; // 当前高度对应的长度
                    bottom = Math.max(left == -1 ? 0 : height[left], height[i]); // 当前结算的最小高度
                    ans += (height[cur] - bottom) * len * (len + 1) / 2;
                }
                stack[size++] = i;
            }
            while (size > 0) {
                cur = stack[--size];
                left = size == 0 ? -1 : stack[size - 1];
                len = n - left - 1;
                bottom = left == -1 ? 0 : height[left];
                ans += (height[cur] - bottom) * len * (len + 1) / 2;
            }
        }
        return ans;
    }
}
