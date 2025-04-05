package lyx.lc.c0;

import java.util.ArrayList;
import java.util.List;

/**
 * 51.N皇后
 */
public class Lc0051 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        solveNQueens0(ans, n, 0, new int[n]);
        return ans;
    }

    private void solveNQueens0(List<List<String>> ans, int n, int col, int[] path) {
        if (col == n) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    if (k == path[j]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            ans.add(list);
            return;
        }
        for (int row = 0; row < n; row++) {
            if (check(path, col, row)) {
                path[col] = row;
                solveNQueens0(ans, n, col + 1, path);
            }
        }
    }

    private boolean check(int[] path, int col, int row) {
        for (int i = col - 1; i >= 0; i--) {
            if (path[i] == row || Math.abs(path[i] - row) == Math.abs(i - col)) {
                return false;
            }
        }
        return true;
    }
}
