package lyx.lc.c1;

/**
 * 130. 被围绕的区域
 *
 * @apiNote DFS + 洪水填充
 */
public class Lc0130 {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int r = 0; r < row; r++) {
            if (board[r][0] == 'O') {
                dfs(board, row, col, r, 0);
            }
            if (board[r][col - 1] == 'O') {
                dfs(board, row, col, r, col - 1);
            }
        }
        for (int c = 0; c < col; c++) {
            if (board[0][c] == 'O') {
                dfs(board, row, col, 0, c);
            }
            if (board[row - 1][c] == 'O') {
                dfs(board, row, col, row - 1, c);
            }
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                if (board[r][c] == 'A') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col, int r, int c) {
        if (r == -1 || r == row || c == -1 || c == col || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'A';
        dfs(board, row, col, r + 1, c);
        dfs(board, row, col, r - 1, c);
        dfs(board, row, col, r, c + 1);
        dfs(board, row, col, r, c - 1);
    }
}
