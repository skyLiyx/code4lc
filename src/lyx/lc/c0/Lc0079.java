package lyx.lc.c0;

/**
 * 79. 单词搜索
 *
 * @apiNote 深度优先搜索
 */
public class Lc0079 {
    private static int m;

    private static int n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int p) {
        if (p == word.length()) {
            return true;
        }
        if (i >= m || i < 0 || j >= n || j < 0 || board[i][j] == '0' || board[i][j] != word.charAt(p)) {
            return false;
        }
        board[i][j] = 0;
        boolean found = dfs(board, i - 1, j, word, p + 1)
                || dfs(board, i + 1, j, word, p + 1)
                || dfs(board, i, j - 1, word, p + 1)
                || dfs(board, i, j + 1, word, p + 1);
        board[i][j] = word.charAt(p);
        return found;
    }
}
