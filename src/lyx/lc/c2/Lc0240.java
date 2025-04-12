package lyx.lc.c2;

/**
 * 240. 搜索二维矩阵 II
 */
public class Lc0240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (matrix[row][col] != target) {
            while (col >= 0 && target < matrix[row][col]) {
                col--;
            }
            if (col == -1) {
                return false;
            }
            while (row < m && target > matrix[row][col]) {
                row++;
            }
            if (row == m) {
                return false;
            }
        }
        return true;
    }
}
