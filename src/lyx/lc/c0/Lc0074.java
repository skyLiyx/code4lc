package lyx.lc.c0;

/**
 * 74. 搜索二维矩阵
 */
public class Lc0074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m - 1, mid;
        // 先找出对应的行
        int row = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (target > matrix[mid][n - 1]) {
                l = mid + 1;
            } else if (target < matrix[mid][0]) {
                r = mid - 1;
            } else {
                row = mid;
                break;
            }
        }
        if (row == -1) { // 没找到这一行，直接返回
            return false;
        }
        // 在这一行找，方式同一维数组
        l = 0;
        r = n - 1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (target > matrix[row][mid]) {
                l = mid + 1;
            } else if (target < matrix[row][mid]) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
