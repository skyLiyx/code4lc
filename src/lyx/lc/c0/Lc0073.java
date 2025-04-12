package lyx.lc.c0;

import java.util.Arrays;

/**
 * 73. 矩阵置零
 */
public class Lc0073 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow0 = false;
        boolean firstCol0 = false;
        for (int r = 0; r < m; r++) {
            if (matrix[r][0] == 0) {
                firstCol0 = true;
                break;
            }
        }
        for (int c = 0; c < n; c++) {
            if (matrix[0][c] == 0) {
                firstRow0 = true;
                break;
            }
        }
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        for (int r = 1; r < m; r++) {
            if (matrix[r][0] == 0) {
                for (int c = 1; c < n; c++) {
                    matrix[r][c] = 0;
                }
            }
        }
        for (int c = 1; c < n; c++) {
            if (matrix[0][c] == 0) {
                for (int r = 1; r < m; r++) {
                    matrix[r][c] = 0;
                }
            }
        }
        if (firstRow0) {
            Arrays.fill(matrix[0], 0);
        }
        if (firstCol0) {
            for (int r = 0; r < m; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}
