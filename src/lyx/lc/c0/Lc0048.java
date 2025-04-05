package lyx.lc.c0;

/**
 * 48. 旋转图像
 */
public class Lc0048 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return;
        }
        // 首先首先左上与右下，对角互换
        for (int row = 0; row < n - 1; row++) {
            for (int col = 0; col < n - 1 - row; col++) {
                swap(matrix, row, col, n - 1 - col, n - 1 - row);
            }
        }
        // 然后每一列上下互换
        for (int col = 0; col < n; col++) {
            int up = 0, down = n - 1;
            while (up < down) {
                swap(matrix, up, col, down, col);
                up++;
                down--;
            }
        }
    }

    private void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
}
