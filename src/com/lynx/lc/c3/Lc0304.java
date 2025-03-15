package com.lynx.lc.c3;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 */
public class Lc0304 {

    public static class NumMatrix {
        private final int[][] sum = new int[201][201];

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // 二维前缀和 = 左边的 + 上边的 - 左上的 + 当前值
                    sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // 前缀和数组比实际位置大1
            row2++;
            col2++;
            return sum[row2][col2] - sum[row2][col1] - sum[row1][col2] + sum[row1][col1];
        }
    }
}
