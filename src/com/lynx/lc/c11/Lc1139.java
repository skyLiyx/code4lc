package com.lynx.lc.c11;

/**
 * 1139. 最大的以 1 为边界的正方形
 */
public class Lc1139 {
    private final int[][] sum = new int[101][101];

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        build(grid, m, n);
        if (sum[m][n] == 0) {
            return 0;
        }
        int ans = 1;
        for (int a = 1; a <= m; a++) {
            for (int b = 1; b <= n; b++) {
                // 遍历每个位置，检查是否存在比当前边长更大的正方形
                for (int c = a + ans, d = b + ans, e = ans + 1; c <= m && d <= n; c++, d++, e++) {
                    int outer = sum(a, b, c, d);
                    int inner = sum(a + 1, b + 1, c - 1, d - 1);
                    if (outer - inner  == ((e - 1) << 2)) {
                        ans = e;
                    }
                }
            }
        }
        return ans * ans;
    }


    private void build(int[][] grid, int m, int n) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
    }

    private int sum(int a, int b, int c, int d) {
        if (a > c) {
            return 0;
        }
        return sum[c][d] - sum[a - 1][d] - sum[c][b - 1] + sum[a - 1][b - 1];
    }
}
