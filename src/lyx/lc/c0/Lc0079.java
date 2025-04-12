package lyx.lc.c0;

/**
 * 79. 单词搜索
 *
 * @apiNote 深度优先搜索
 */
public class Lc0079 {
    private static final int[] move = {1, 0, -1, 0, 1};

    private static int m;

    private static int n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        char[] s = word.toCharArray();
        // 优化1: word中某个字符的数量超过该字符在网格中的总数，一定匹配不了
        int[] cnt1 = new int[128];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt1[board[i][j]]++;
            }
        }
        int[] cnt2 = new int[128];
        for (char c : s) {
            if (++cnt2[c] > cnt1[c]) {
                return false;
            }
        }
        // 优化2: 如果首字母在网格中的数量比尾字母要多，从尾部到首部搜索更快
        if (cnt1[s[0]] > cnt1[s[s.length - 1]]) {
            s = new StringBuilder(word).reverse().toString().toCharArray();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, s, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] s, int p) {
        if (p == s.length) {
            return true;
        }
        if (i >= m || i < 0 || j >= n || j < 0 || board[i][j] == '0' || board[i][j] != s[p]) {
            return false;
        }
        board[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            if (dfs(board, i + move[k], j + move[k + 1], s, p + 1)) {
                return true;
            }
        }
        board[i][j] = s[p];
        return false;
    }
}
