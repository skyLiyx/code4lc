package lyx.lc.c0;

/**
 * 36. 有效的数独
 */
public class Lc0036 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] box = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    row[i][c - '1']++;
                    col[j][c - '1']++;
                    box[i / 3][j / 3][c - '1']++;
                    if (row[i][c - '1'] > 1 || col[j][c - '1'] > 1 || box[i / 3][j / 3][c - '1'] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
