package com.lynx.lcp;

import java.util.Arrays;

/**
 * LCP 74. 最强祝福力场
 *
 * @apiNote 离散化差分
 */
public class LCP74 {
    public int fieldOfGreatestBlessing(int[][] forceField) {
        // forceField: [x,y,s] 以 x, y 为中心, s 为边长
        int n = forceField.length;
        // 矩阵离散化，避免大空间
        // 统计有多少个x点和y点
        long[] xs = new long[n << 1];
        long[] ys = new long[n << 1];
        for (int i = 0, j = 0, k = 0; i < n; i++) {
            // 数据离散化
            // 中心点 x = x * 2 + s
            // 中心点 y = y * 2 + s
            // 边长   s = s * 2
            long x = forceField[i][0];
            long y = forceField[i][1];
            long s = forceField[i][2];
            xs[j++] = (x << 1) - s;
            xs[j++] = (x << 1) + s;
            ys[k++] = (y << 1) - s;
            ys[k++] = (y << 1) + s;
        }
        // 得到y排序去重的有效个数
        int sizey = sort(ys);
        // 得到x排序去重的有效个数
        int sizex = sort(xs);
        // 构建差分
        int[][] diff = new int[sizey + 2][sizex + 2];
        for (int i = 0, a, b, c, d; i < n; i++) {
            long x = forceField[i][0];
            long y = forceField[i][1];
            long s = forceField[i][2];
            a = rank(ys, (y << 1) - s, sizey);
            b = rank(xs, (x << 1) - s, sizex);
            c = rank(ys, (y << 1) + s, sizey);
            d = rank(xs, (x << 1) + s, sizex);
            add(diff, a, b, c, d);
        }
        int ans = 0;
        for (int i = 1; i < diff.length; i++) {
            for (int j = 1; j < diff[i].length; j++) {
                diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
                ans = Math.max(ans, diff[i][j]);
            }
        }
        return ans;
    }

    private int sort(long[] arr) {
        Arrays.sort(arr);
        int size = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[size - 1]) {
                arr[size++] = arr[i];
            }
        }
        return size;
    }

    private int rank(long[] arr, long val, int size) {
        int ans = 0;
        int l = 0, r = size - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] >= val) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans + 1;
    }

    private void add(int[][] diff, int a, int b, int c, int d) {
        diff[a][b] += 1;
        diff[a][d + 1] -= 1;
        diff[c + 1][b] -= 1;
        diff[c + 1][d + 1] += 1;
    }
}
