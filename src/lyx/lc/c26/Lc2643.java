package lyx.lc.c26;

/**
 * 2643. 一最多的行
 *
 * @date 2025/03/22
 */
public class Lc2643 {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int maxRow = 0, maxCnt = 0;
        for (int row = 0, cnt; row < m; row++) {
            cnt = 0;
            for (int col = 0; col < n; col++) {
                cnt += mat[row][col];
            }
            if (cnt > maxCnt) {
                maxRow = row;
                maxCnt = cnt;
            }
        }
        return new int[]{ maxRow, maxCnt };
    }
}
